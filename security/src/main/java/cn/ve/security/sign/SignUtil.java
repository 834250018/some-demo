package cn.ve.security.sign;

import cn.ve.security.CertificateDemo1;
import com.google.common.io.ByteStreams;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.MakeSignature;
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
 * @description
 */
public class SignUtil {

    private final static String PATH = "src/main/java/com/ywy/demo/sign/";

    public static void main(String[] args) throws Exception {
        // 设置优先使用bc的算法库
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        // 待签名的pdf
        String pdfPath = PATH + "1.pdf";
        // 要输出的路径
        String outputPath = PATH + "result.pdf";
        // 自己随便生成的一个p12自签名证书
        String keyStorePath = PATH + "3.pfx";
        // 印模
        String imgPath = PATH + "2.png";
        signDemo(pdfPath, imgPath, outputPath, keyStorePath);
    }

    /**
     * 电子签章demo
     *
     * @param pdfPath      待签名pdf路径
     * @param imgPath      印模路径
     * @param outputPath   最终签名结果文件路径
     * @param keyStorePath pkcs12的keyStore路径
     * @throws Exception
     */
    private static void signDemo(String pdfPath, String imgPath, String outputPath, String keyStorePath)
        throws Exception {
        File pdf = new File(pdfPath);
        File result = new File(outputPath);
        if (result.exists()) {
            result.delete();
        }
        KeyStore keyStore = CertificateDemo1.getKeyStore("pkcs12", "", keyStorePath);

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
        // 签名时间
        appearance.setSignDate(Calendar.getInstance());
        // 签名位置大小
        com.itextpdf.awt.geom.Rectangle rect = new com.itextpdf.awt.geom.Rectangle();
        // 普通情况下坐标原点在pdf坐下角,x为从左往右,y为从下往上
        rect.setBounds(100, 400, 100, 100);
        appearance.setVisibleSignature(new Rectangle(rect), 1, "test" + System.currentTimeMillis());
        // 签名图片
        appearance.setSignatureGraphic(Image.getInstance(imgPath));
        // 签名等级,允许继续签名
        appearance.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
        // 签名展示模式,仅图片
        appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
        // 调用外部容器进行签名
        MakeSignature.signExternalContainer(appearance,
            new MyExternalSignatureContainer(CertificateDemo1.getCertPrivateKeyByFirstAlias(keyStore, null),
                keyStore.getCertificateChain(CertificateDemo1.getFirstAlias(keyStore))), 81920);
    }

}
