package com.ywy.demo.security;

import sun.security.pkcs10.PKCS10;
import sun.security.x509.*;

import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Random;

/**
 * 证书颁发
 *
 * @author ve
 * @date 2020/2/18 11:56
 */
public class CertificateDemo2 {

    public static void main(String[] args) throws Exception {
        // 生成用户自己的非对称密钥对
        KeyPair keyPair = PublicKeyDemo.generateKeyPair();
        // 生成csr
        PKCS10 pkcs10 = CertificateDemo1.generatePKCS10("ve", "ve", "ve", "ve", "ve", "ve", keyPair.getPublic(), keyPair.getPrivate());
        // 获取ca的私钥跟证书(即demo1中生成的自签名证书)
        KeyStore keyStore = CertificateDemo1.getKeyStore("pkcs12", "", "d://b.pfx");
        PrivateKey caPrivateKey = CertificateDemo1.getCertPrivateKeyByFirstAlias(keyStore, null);
        Certificate caCert = CertificateDemo1.getCertByFirstAlias(keyStore);

        // 自签名证书:3.颁发证书

        // 设置有效期
        CertificateValidity certificateValidity = new CertificateValidity(new Date(), new Date(new Date().getTime() + 365 * 24 * 60 * 60 * 1000L));
        // 设置证书信息
        X509CertInfo x509CertInfo = new X509CertInfo();
        x509CertInfo.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        x509CertInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber((new Random()).nextInt() & 2147483647));
        AlgorithmId algorithmId = AlgorithmId.get("SHA256withRSA");
        x509CertInfo.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algorithmId));
        x509CertInfo.set(X509CertInfo.SUBJECT, pkcs10.getSubjectName());
        x509CertInfo.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
        x509CertInfo.set(X509CertInfo.VALIDITY, certificateValidity);
        x509CertInfo.set(X509CertInfo.ISSUER, ((X509CertImpl) caCert).getSubjectDN());

        X509CertImpl x509Cert = new X509CertImpl(x509CertInfo);
        // 使用ca私钥对证书信息进行签名(包含摘要跟加密)
        x509Cert.sign(caPrivateKey, "SHA256withRSA");

        // 存储证书
        CertificateDemo1.saveCRT(x509Cert, "d://result.crt");
        // 最终证书可能会出现两个问题
        // 1.证书显示无法校验:需要导入ca证书
        // 2.证书含有一个错误的数字签名,导入的ca证书不是上面的b.pfx(比如,导入了一个a.pfx,但是dn信息与b.pfx完全相同)

        // todo 颁发完证书之后要把证书链存起来
        Certificate[] certChain = {x509Cert, caCert};
        System.out.println(certChain);
    }

}
