package com.ywy.demo.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要
 * @author ve
 * @date 2020/2/17 13:56
 */
public class MessageDigestDemo {

    // todo SHA*: where * is 1, 224, 256, 384 and 512
    private static MessageDigest md5MessageDigest;
    private static MessageDigest sha1MessageDigest;
    public static MessageDigest sha256MessageDigest;
    private static MessageDigest sha512MessageDigest;
    // todo SHA3-*: where * is 224, 256, 384 and 512
    // todo SM3
    private static MessageDigest sm3MessageDigest;
    // todo Ed25519, Ed448

    static {
        try {
            md5MessageDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sha1MessageDigest = MessageDigest.getInstance("sha1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sha256MessageDigest = MessageDigest.getInstance("sha-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sha512MessageDigest = MessageDigest.getInstance("sha-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getMD5(byte[] data) {
        return md5MessageDigest.digest(data);
    }

    public static byte[] getSHA1(byte[] data) {
        return sha1MessageDigest.digest(data);
    }

    public static byte[] getSHA256(byte[] data) {
        return sha256MessageDigest.digest(data);
    }

    public static byte[] getSHA512(byte[] data) {
        return sha512MessageDigest.digest(data);
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(byte2hex(getMD5(str.getBytes())));
        System.out.println(byte2hex(getSHA1(str.getBytes())));
        System.out.println(byte2hex(getSHA256(str.getBytes())));
        System.out.println(byte2hex(getSHA512(str.getBytes())));
    }
}
