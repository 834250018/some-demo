package com.ywy.demo.sign;

import com.google.common.io.ByteStreams;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.codec.Base64;
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
            //            byte[] sha256s = DigestAlgorithms.digest(data, "SHA256", null);
            byte[] hash = MessageDigest.getInstance("SHA1", "BC").digest(ByteStreams.toByteArray(data));

            System.out.println();
            System.out.println("hash" + "\n" + Base64.encodeBytes(hash));
            // 创建一个p7容器,此处不传私钥
            PdfPKCS7 p7 = new PdfPKCS7(null, chain, "SHA256", "BC", new BouncyCastleDigest(), false);
            // 使用p7规范对hash值进行签名
            byte[] authenticatedAttributeBytes =
                p7.getAuthenticatedAttributeBytes(hash, null, null, MakeSignature.CryptoStandard.CMS);
            System.out.println();
            System.out.println("authenticatedAttributeBytes" + "\n" + Base64.encodeBytes(authenticatedAttributeBytes));
            // 使用私钥对auth进行签署
            byte[] encryptData = sign(authenticatedAttributeBytes);
            System.out.println();
            System.out.println("encryptData" + "\n" + Base64.encodeBytes(encryptData));
            // 签名值密文写入p7容器
            p7.setExternalDigest(encryptData, null, "RSA");
            // todo 加入数字时间戳
            // 将p7容器转化成p7证书
            byte[] encodedPKCS7 = p7.getEncodedPKCS7(hash, null, null, null, MakeSignature.CryptoStandard.CMS);
            System.out.println();
            System.out.println("encodedPKCS7" + "\n" + Base64.encodeBytes(encodedPKCS7));
            return encodedPKCS7;
            // fixme 签名后的pdf显示签名已失效,文档被修改或损坏,暂时没什么思路在这里记一下
            // fixme 试一下通过itextpdf读取签名信息,看看有什么问题
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private byte[] sign(byte[] input) throws Exception {
        byte[] digest = MessageDigest.getInstance("SHA1", "BC").digest(input);
        return AsymetricEncryptionDemo.encrypt(digest, privateKey);
    }

    @Override public void modifySigningDictionary(PdfDictionary signDic) {
        signDic.put(PdfName.FILTER, PdfName.ADOBE_PPKLITE);
        signDic.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_DETACHED);
    }

}
