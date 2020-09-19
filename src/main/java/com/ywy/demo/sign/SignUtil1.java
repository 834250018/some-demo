package com.ywy.demo.sign;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.CertificateInfo;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * @author ve
 * @date 2020/9/19
 * @motto 这火我不传了!!!
 * @description
 */
public class SignUtil1 {

    public static void main(String[] args) throws Exception {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        PdfReader reader = new PdfReader("D:\\result.pdf");

        AcroFields acroFields = reader.getAcroFields();
        for (String s : acroFields.getSignatureNames()) {
            PdfPKCS7 pkcs7 = acroFields.verifySignature(s);
            System.out.println("Subject: " + CertificateInfo.getSubjectFields(pkcs7.getSigningCertificate()));
            System.out.println("Document verifies: " + pkcs7.verify());
            System.out.println();
        }
    }
}
