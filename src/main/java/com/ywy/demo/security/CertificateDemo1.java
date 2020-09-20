package com.ywy.demo.security;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;
import sun.security.pkcs10.PKCS10;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.*;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

/**
 * 生成自签名证书
 *
 * @author ve
 * @date 2020/2/17 16:04
 */
@Slf4j
public class CertificateDemo1 {

    public static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----";
    public static final String END_CERT = "-----END CERTIFICATE-----";
    public final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws Exception {
        genSelfSignedCertificate();
        genSelfSignedCertificate1();
        // 有私钥的证书
        KeyStore keyStore = getKeyStore("pkcs12", "", "d://3.pfx");
        KeyStore keyStore1 = getKeyStore("jks", "", "d://a.jks");
        // 无私钥的证书
        getCert("d://rootCa.cer");
        getCert("d://rootCa.pem");
        // todo crt类型不行
        //   getCert("d://rootCa.crt");
    }

    /**
     * 通过CertAndKeyGen生成自签名证书
     *
     * @throws Exception
     */
    private static void genSelfSignedCertificate1() throws Exception {
        CertAndKeyGen cak = new CertAndKeyGen("RSA", "SHA256withRSA", null);
        cak.setRandom(new SecureRandom());
        cak.generate(1024);
        X509Certificate x509Certificate = cak.getSelfCertificate(new X500Name("aa", "bb", "cc", "dd", "ee", "ff"), 50 * 365 * 24 * 60 * 60L);
        saveCRT(x509Certificate, "d://rootCa.crt");
        saveCER(x509Certificate, "d://rootCa.cer");
        savePEM(x509Certificate, "d://rootCa.pem");
        X509Certificate[] certs = {x509Certificate};
        saveKeyStore("pkcs12", "ca", cak.getPrivateKey(), null, null, certs, "d://3.pfx");
    }

    private static void saveCER(X509Certificate x509Certificate, String filepath) throws Exception {
        FileOutputStream fos = new FileOutputStream(filepath);
        fos.write(x509Certificate.getEncoded());
        fos.flush();
        fos.close();
    }

    private static void savePEM(X509Certificate x509Certificate, String filepath) throws Exception {
        Base64.Encoder encoder = Base64.getMimeEncoder(64, LINE_SEPARATOR.getBytes());
        byte[] rawCrtText = x509Certificate.getEncoded();
        String encodedCertText = new String(encoder.encode(rawCrtText));
        String prettified_cert = BEGIN_CERT + LINE_SEPARATOR + encodedCertText + LINE_SEPARATOR + END_CERT;
        FileOutputStream fos = new FileOutputStream(filepath);
        PrintStream printStream = new PrintStream(fos);
        printStream.print(prettified_cert);
        printStream.close();
        fos.close();
    }

    public static void saveCRT(X509Certificate x509Certificate, String filepath) throws Exception {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        FileOutputStream fos = new FileOutputStream(filepath);
        base64Encoder.encodeBuffer(x509Certificate.getEncoded(), fos);
        fos.close();
    }

    /**
     * 自实现自签名证书
     *
     * @throws Exception
     */
    private static void genSelfSignedCertificate() throws Exception {
        // 自签名证书:1.生成密钥对
        KeyPair keyPair = AsymetricEncryptionDemo.generateKeyPair();
        // 自签名证书:2.生成证书请求文件
        byte[] csr = generatePKCS10Bytes("aa", "bb", "cc", "dd", "ee", "ff", keyPair.getPublic(), keyPair.getPrivate());
        log.info("csr:  " + new String(csr));

        X500Name x500Name = new X500Name("aa", "bb", "cc", "dd", "ee", "ff");
        // 自签名证书:3.颁发证书

        // 设置有效期
        CertificateValidity certificateValidity = new CertificateValidity(new Date(), new Date(new Date().getTime() + 100 * 365 * 24 * 60 * 60 * 1000L));
        // 设置证书信息
        X509CertInfo x509CertInfo = new X509CertInfo();
        x509CertInfo.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        x509CertInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber((new Random()).nextInt() & 2147483647));
        AlgorithmId algorithmId = AlgorithmId.get("SHA256withRSA");
        x509CertInfo.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algorithmId));
        x509CertInfo.set(X509CertInfo.SUBJECT, x500Name);
        x509CertInfo.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
        x509CertInfo.set(X509CertInfo.VALIDITY, certificateValidity);
        x509CertInfo.set(X509CertInfo.ISSUER, x500Name);

        X509CertImpl x509Cert = new X509CertImpl(x509CertInfo);
        // 使用私钥对证书信息进行签名(包含摘要跟加密)
        x509Cert.sign(keyPair.getPrivate(), "SHA256withRSA");
        X509Certificate[] certChain = {x509Cert};

        // 自签名证书:4.keyStore存储证书及密钥
        saveKeyStore("JKS", "CA", keyPair.getPrivate(), null, null, certChain, "d://a.JKS");
    }

    /**
     * 保存证书,含密钥
     *
     * @param type       类型 JKS/pkcs12 二选一
     * @param alias      别名
     * @param privateKey 私钥
     * @param certPass   使用证书时的密码,可为空
     * @param storePwd   密钥库密码,可为空
     * @param certChain  证书链
     * @param filepath   输出文件
     * @throws Exception
     */
    private static void saveKeyStore(String type, String alias, PrivateKey privateKey, String certPass, String storePwd, X509Certificate[] certChain, String filepath) throws Exception {
        if (storePwd == null) {
            storePwd = "";
        }
        if (certPass == null) {
            certPass = "";
        }
        // 实例化密钥库,指定类型
        KeyStore keyStore = KeyStore.getInstance(type);
        // 第一个参数为null,为创建秘钥库
        keyStore.load(null, storePwd.toCharArray());
        keyStore.setKeyEntry(alias, privateKey, certPass.toCharArray(), certChain);
        FileOutputStream fos = new FileOutputStream(filepath);
        keyStore.store(fos, storePwd.toCharArray());
        fos.close();
    }

    /**
     * 读取密钥库
     *
     * @param type     密钥库类型 JKS/pkcs12 二选一
     * @param storePwd 密钥库访问密码
     * @param filepath keystore文件路径
     * @return
     * @throws Exception
     */
    public static KeyStore getKeyStore(String type, String storePwd, String filepath) throws Exception {
        if (storePwd == null) {
            storePwd = "";
        }
        // 实例化密钥库,指定类型
        KeyStore keyStore = KeyStore.getInstance(type);
        FileInputStream fis = new FileInputStream(filepath);
        // 加载密钥库
        keyStore.load(fis, storePwd.toCharArray());
        fis.close();
        return keyStore;
    }

    /**
     * 读取密钥库证书及私钥
     *
     * @param certPass 证书访问密码
     * @return
     * @throws Exception
     */
    public static PrivateKey getCertPrivateKeyByFirstAlias(KeyStore keyStore, String certPass) throws Exception {
        if (certPass == null) {
            certPass = "";
        }
        String alias = getFirstAlias(keyStore);

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, certPass.toCharArray());
        return privateKey;
    }

    /**
     * 读取密钥库证书及私钥
     *
     * @return
     * @throws Exception
     */
    public static Certificate getCertByFirstAlias(KeyStore keyStore) throws Exception {
        String alias = getFirstAlias(keyStore);
        return keyStore.getCertificate(alias);
    }

    public static String getFirstAlias(KeyStore keyStore) throws KeyStoreException {
        Enumeration aliases = keyStore.aliases();
        String alias = null;
        if (aliases.hasMoreElements()) {
            alias = (String) aliases.nextElement();
        }
        return alias;
    }

    /**
     * @param cn         common name
     * @param ou         organizational unit
     * @param o          organization name
     * @param location
     * @param state
     * @param country
     * @param publicKey  公钥需要存入csr
     * @param privateKey 私钥仅用于签名,不存入csr
     * @return
     * @throws Exception
     */
    public static PKCS10 generatePKCS10(String cn, String ou,
                                        String o, String location,
                                        String state, String country,
                                        PublicKey publicKey, PrivateKey privateKey) throws Exception {
        PKCS10 pkcs10 = new PKCS10(publicKey);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        X500Name x500Name = new X500Name(cn, ou, o, location, state, country);
        pkcs10.encodeAndSign(x500Name, signature);
        return pkcs10;
    }

    public static byte[] generatePKCS10Bytes(String cn, String ou,
                                             String o, String location,
                                             String state, String country,
                                             PublicKey publicKey, PrivateKey privateKey) throws Exception {
        PKCS10 pkcs10 = new PKCS10(publicKey);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        X500Name x500Name = new X500Name(cn, ou, o, location, state, country);
        pkcs10.encodeAndSign(x500Name, signature);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        pkcs10.print(ps);
        byte[] c = bos.toByteArray();
        ps.close();
        bos.close();

        return c;
    }

    public static X509Certificate getCert(String filepath) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(new FileInputStream(filepath));
//      获取公钥
//        PublicKey publicKey = cert.getPublicKey();
        return cert;


    }

}
