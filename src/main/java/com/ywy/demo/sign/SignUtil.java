package com.ywy.demo.sign;

import com.google.common.io.ByteStreams;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.ywy.demo.security.CertificateDemo1;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.Security;
import java.util.Calendar;

/**
 * @author ve
 * @date 2020/9/19
 * @motto 这火我不传了!!!
 * @description
 */
public class SignUtil {

    public static void main(String[] args) throws Exception {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        File pdf = new File("D:\\1.pdf");
        File result = new File("D:\\result.pdf");
        if (result.exists()) {
            result.delete();
        }
        KeyStore keyStore = CertificateDemo1.getKeyStore("pkcs12", "", "d://b.pfx");

        PdfReader pdfReader = new PdfReader(ByteStreams.toByteArray(new FileInputStream(pdf)));
        PdfStamper signature = PdfStamper.createSignature(pdfReader, new FileOutputStream(result), '\0', null, true);
        PdfSignatureAppearance appearance = signature.getSignatureAppearance();
        // 签名原因
        appearance.setReason("test");
        // 签名地点
        appearance.setLocation("home");
        // 签署人
        appearance.setSignatureCreator("ve");
        // 联系人
        appearance.setContact("ve");
        // 签名时间 todo 使用数字时间戳
        appearance.setSignDate(Calendar.getInstance());
        // 签名位置大小
        com.itextpdf.awt.geom.Rectangle rect = new com.itextpdf.awt.geom.Rectangle();
        // 普通情况下坐标原点在pdf坐下角,x为从左往右,y为从下往上
        rect.setBounds(100, 700, 100, 100);
        appearance.setVisibleSignature(new Rectangle(rect), 1, "test" + System.currentTimeMillis());
        // 签名图片
        appearance.setSignatureGraphic(Image.getInstance("D:\\2.png"));
        // 签名等级,允许继续签名
        appearance.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
        // 签名展示模式,仅图片
        appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
        //        appearance.setCertificate(keyStore.getCertificate(alias));
        // 进行签名
        MakeSignature.signExternalContainer(appearance,
            new MyExternalSignatureContainer(CertificateDemo1.getCertPrivateKeyByFirstAlias(keyStore, null),
                keyStore.getCertificateChain(CertificateDemo1.getFirstAlias(keyStore))), 81920);

    }

}
