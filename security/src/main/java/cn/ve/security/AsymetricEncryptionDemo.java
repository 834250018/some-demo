package cn.ve.security;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.security.*;

/**
 * RSA非对称加解密
 *
 * @author ve
 * @date 2020/2/17 14:44
 */
@Slf4j
public class AsymetricEncryptionDemo {
    /** todo
     * RSA
     * EC
     * DSA
     * Ed25519, Ed448
     * SM2
     * X25519, X448
     */
    /**
     * 指定加密算法为RSA
     */
    public static final String ALGORITHM = "RSA";
    /**
     * 密钥长度，用来初始化
     */
    private static final int KEYSIZE = 1024;


    public static byte[] encrypt(byte[] bytes, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(bytes);
    }

    public static byte[] decrypt(byte[] bytes, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(bytes);
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEYSIZE, new SecureRandom());
        return keyPairGenerator.genKeyPair();
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        log.info("");
        String str = "hello world!";
        String result = new String(decrypt(encrypt(str.getBytes(), privateKey), publicKey));
        log.info(result);
        String str2 = "test public key encrypt";
        String result1 = new String(decrypt(encrypt(str.getBytes(), publicKey), privateKey));
        log.info(result1);
    }
}
