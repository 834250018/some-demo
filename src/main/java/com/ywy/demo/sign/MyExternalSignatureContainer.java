package com.ywy.demo.sign;

import com.google.common.io.ByteStreams;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.ExternalSignatureContainer;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.ywy.demo.security.AsymetricEncryptionDemo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * @author ve
 * @date 2020/9/19
 * @motto 这火我不传了!!!
 * @description
 */
@Data @AllArgsConstructor public class MyExternalSignatureContainer implements ExternalSignatureContainer {

    protected PrivateKey privateKey;
    protected Certificate[] chain;

    /**
     * @param data 要签名的数据,比如pdf,会截取一段摘要
     * @return 根据modifySigningDictionary方法放入的字典来判断要返回什么, 比如ADBE_PKCS7_DETACHED, 及此方法要返回PKCS7SignedData对象的字节
     * @throws GeneralSecurityException
     */
    @Override public byte[] sign(InputStream data) throws GeneralSecurityException {
        try {
            // 对数据进行sha256
            byte[] hash = MessageDigest.getInstance("SHA-1").digest(ByteStreams.toByteArray(data));
            // 创建一个p7容器,此处不传私钥
            PdfPKCS7 p7 = new PdfPKCS7(null, chain, "SHA256", null, new BouncyCastleDigest(), false);
            // 使用p7规范对hash值进行签名
            byte[] authenticatedAttributeBytes =
                p7.getAuthenticatedAttributeBytes(hash, null, null, MakeSignature.CryptoStandard.CMS);
            // 使用私钥对sh进行签署
            byte[] encryptData = sign(authenticatedAttributeBytes);
            // 签名值密文写入p7容器
            p7.setExternalDigest(encryptData, null, "RSA");
            // todo 加入数字时间戳
            // 将p7容器转化成数字证书
            return p7.getEncodedPKCS7(hash, null, null, null, MakeSignature.CryptoStandard.CMS);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private byte[] sign(byte[] input) throws Exception {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(input);
        byte[] encrypt = AsymetricEncryptionDemo.encrypt(digest, privateKey);
        return encrypt;
    }

    @Override public void modifySigningDictionary(PdfDictionary signDic) {
//        signDic.put(PdfName.FILTER, PdfName.ADOBE_PPKLITE);
        signDic.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_DETACHED);
    }

}
