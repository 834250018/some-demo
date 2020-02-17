package com.ywy.demo.security;

import sun.security.pkcs10.PKCS10;
import sun.security.x509.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Random;

/**
 * 证书相关
 *
 * @author ve
 * @date 2020/2/17 16:04
 */
public class CertificateDemo {

    public static PrivateKey privateKey;
    public static PublicKey publicKey;

    public static void main(String[] args) throws Exception {
        // 自签名证书:1.生成密钥对
        KeyPair keyPair = PublicKeyDemo.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
        // 自签名证书:2.生成证书请求文件
        byte[] csr = generatePKCS10("aa", "bb", "cc", "dd", "ee", "ff");
        System.out.println("csr:  " + new String(csr));

        PKCS10 pkcs10 = new PKCS10(csr);
        // 自签名证书:3.颁发证书

        // 设置有效期
        CertificateValidity certificateValidity = new CertificateValidity(new Date(), new Date(new Date().getTime() + 100 * 365 * 24 * 60 * 60 * 1000));
        // 设置证书信息
        X509CertInfo x509CertInfo = new X509CertInfo();
        x509CertInfo.set("version", new CertificateVersion(2));
        x509CertInfo.set("serialNumber", new CertificateSerialNumber((new Random()).nextInt() & 2147483647));
        AlgorithmId algorithmId = AlgorithmId.get("SHA256withRSA");
        x509CertInfo.set("algorithmID", new CertificateAlgorithmId(algorithmId));
        x509CertInfo.set("subject", pkcs10.getSubjectName());
        x509CertInfo.set("key", new CertificateX509Key(publicKey));
        x509CertInfo.set("validity", certificateValidity);
        x509CertInfo.set("issuer", pkcs10.getSubjectName());

        X509CertImpl x509Cert = new X509CertImpl(x509CertInfo);
        // 使用私钥对证书信息进行签名(包含摘要跟加密)
        x509Cert.sign(privateKey, "SHA256withRSA");
        X509Certificate certificate = x509Cert;

        // 自签名证书:4.keyStore存储证书及密钥
        File store = new File("d://aa.keystore");
        String storePass = "adminadmin";
        String caPass = "admin123";
        X509Certificate[] certs = {certificate};
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, storePass.toCharArray());
        keyStore.setKeyEntry("CA", privateKey, caPass.toCharArray(), certs);
        FileOutputStream fos = new FileOutputStream(store);
        keyStore.store(fos, storePass.toCharArray());
        fos.close();
    }

    /**
     * @param cn       common name
     * @param ou       organizational unit
     * @param o        organization name
     * @param location
     * @param state
     * @param country
     * @return
     * @throws Exception
     */
    public static byte[] generatePKCS10(String cn, String ou,
                                        String o, String location,
                                        String state, String country) throws Exception {
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
}
