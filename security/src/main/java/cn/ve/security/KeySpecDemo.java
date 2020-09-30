package cn.ve.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.spec.RSAPublicKeySpec;

/**
 * Key转KeySpec
 *
 * @author ve
 * @date 2020/2/17 15:58
 */
public class KeySpecDemo {
    public static void main(String[] args) throws Exception {
        KeyPair keyPair = AsymetricEncryptionDemo.generateKeyPair();
        KeyFactory factory = KeyFactory.getInstance(AsymetricEncryptionDemo.ALGORITHM);
        RSAPublicKeySpec rsaPublicKeySpec = factory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
        rsaPublicKeySpec.getModulus();
        rsaPublicKeySpec.getPublicExponent();

    }
}
