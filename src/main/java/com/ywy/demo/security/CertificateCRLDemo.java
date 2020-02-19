package com.ywy.demo.security;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509v2CRLBuilder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509CRL;
import java.util.Date;

/**
 * @author ve
 * @date 2020/2/19 10:56
 */
public class CertificateCRLDemo {
    public static void main(String[] args) throws Exception {
        generateV2CRLCert();
    }

    /**
     *
     * @param revokedCerts
     * @param revokedDates
     * @param crlReasons
     * @param dirName
     * @param privateKey
     * @param outputPath
     * @return
     * @throws Exception
     */
    public static X509CRL generateV2CRLCert(BigInteger[] revokedCerts, Date[] revokedDates, int[] crlReasons,
                                            String dirName, PrivateKey privateKey, String outputPath) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        X509v2CRLBuilder builder = new X509v2CRLBuilder(new X500Name(dirName), new Date());

        for (int i = 0; i < revokedCerts.length; i++) {
            builder.addCRLEntry(revokedCerts[i], revokedDates[i], crlReasons[i]);

        }
        BcRSAContentSignerBuilder bcRSAContentSignerBuilder = new BcRSAContentSignerBuilder(
                new DefaultSignatureAlgorithmIdentifierFinder().find("SHA256withRSA"),
                new DefaultDigestAlgorithmIdentifierFinder().find("SHA256"));
        bcRSAContentSignerBuilder.setSecureRandom(new SecureRandom());
        // 此处使用的私钥必须是ca的私钥
        AsymmetricKeyParameter foo = PrivateKeyFactory.createKey(privateKey.getEncoded());

        ContentSigner signer = bcRSAContentSignerBuilder.build(foo);
        X509CRLHolder x509CRLHolder = builder.build(
                signer
        );
        byte[] bytes = x509CRLHolder.getEncoded();
        FileOutputStream fos = new FileOutputStream(outputPath);
        fos.write(bytes);
        fos.close();


//        return (X509CRL) crl;

        return null;
    }

    public static void createCRLCert() {

    }
}
