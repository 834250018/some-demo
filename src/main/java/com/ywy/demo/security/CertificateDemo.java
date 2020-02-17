package com.ywy.demo.security;

import sun.security.pkcs10.PKCS10;
import sun.security.x509.X500Name;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

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
        // 自签名证书:3.颁发证书
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
