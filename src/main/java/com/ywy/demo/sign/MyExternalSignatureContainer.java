package com.ywy.demo.sign;

import com.google.common.io.ByteStreams;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.ExternalSignatureContainer;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

/**
 * @author ve
 * @date 2020/9/19
 * @motto 这火我不传了!!!
 * @description
 */
@Data @AllArgsConstructor public class MyExternalSignatureContainer implements ExternalSignatureContainer {

    /**
     * 私钥
     */
    protected PrivateKey privateKey;
    /**
     * 证书链
     */
    protected Certificate[] chain;
    private final static String PROVIDER = "BC";
    private final static String SIG_ALGORITHM = "RSA";
    private final static String DIGEST_ALGORITHM = "SHA256";

    /**
     * @param data 要签名的数据,比如pdf,会截取一段摘要
     * @return 根据modifySigningDictionary方法放入的字典来判断要返回什么, 比如ADBE_PKCS7_DETACHED, 及此方法要返回PKCS7SignedData对象的字节(即p7证书的byte数组)
     * @throws GeneralSecurityException
     */
    @Override public byte[] sign(InputStream data) throws GeneralSecurityException {
        try {
            // 对数据进行sha256
            byte[] hash = MessageDigest.getInstance(DIGEST_ALGORITHM, PROVIDER).digest(ByteStreams.toByteArray(data));
            // 创建一个p7容器(即证书),此处不传私钥
            PdfPKCS7 p7 = new PdfPKCS7(null, chain, DIGEST_ALGORITHM, PROVIDER, new BouncyCastleDigest(), false);
            // 使用p7规范对hash值进行转换,生成符合规范的可用的hash
            byte[] attrs = p7.getAuthenticatedAttributeBytes(hash, null, null, MakeSignature.CryptoStandard.CMS);
            // 使用私钥对attrs进行签名
            byte[] signData = sign(attrs);
            // 数字签名写入p7容器
            p7.setExternalDigest(signData, null, SIG_ALGORITHM);
            // todo 加入数字时间戳
            // 将要签名的数据放入p7容器,将p7容器(即证书)转化成byte[]
            byte[] encodedPKCS7 = p7.getEncodedPKCS7(hash, null, null, null, MakeSignature.CryptoStandard.CMS);
            return encodedPKCS7;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 对byte[]进行SHA256withRSA签名
     *
     * @param input 待签名的数据
     * @return 数字签名
     * @throws Exception
     */
    private byte[] sign(byte[] input) throws Exception {
        // 创建签名算法
        Signature instance = Signature.getInstance(DIGEST_ALGORITHM + "with" + SIG_ALGORITHM, PROVIDER);
        // 签名需要私钥
        instance.initSign(privateKey);
        // 加载待签名数据
        instance.update(input);
        // 返回签名结果
        return instance.sign();
    }

    /**
     * pdf字典,确定此容器签名方法的返回值是什么
     * 比如ADBE_PKCS7_DETACHED,则返回sha256withRSA签名的p7
     * 比如ADBE_PKCS7_SHA1,则返回sha1摘要的p7
     *
     * @param signDic
     */
    @Override public void modifySigningDictionary(PdfDictionary signDic) {
        signDic.put(PdfName.FILTER, PdfName.ADOBE_PPKLITE);
        signDic.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_DETACHED);
    }

}
