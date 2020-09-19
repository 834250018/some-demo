package com.ywy.demo.sign;

import com.itextpdf.text.pdf.security.ExternalSignature;
import com.ywy.demo.security.AsymetricEncryptionDemo;
import com.ywy.demo.security.MessageDigestDemo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;

/**
 * @author ve
 * @date 2020/9/19
 * @motto 这火我不传了!!!
 * @description
 */
@Data @AllArgsConstructor public class MyExternalSignature implements ExternalSignature {
    private PrivateKey privateKey;

    @Override public String getHashAlgorithm() {
        return "SHA256";
    }

    @Override public String getEncryptionAlgorithm() {
        return "SHA256withRSA";
    }

    @Override public byte[] sign(byte[] message) throws GeneralSecurityException {
        try {
            byte[] sha = MessageDigestDemo.sha(256, message);
            return AsymetricEncryptionDemo.encrypt(sha, privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
