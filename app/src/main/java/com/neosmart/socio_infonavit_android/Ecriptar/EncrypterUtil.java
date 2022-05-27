package com.neosmart.socio_infonavit_android.Ecriptar;

import android.util.Base64;

import com.neosmart.socio_infonavit_android.Modelos.LlavePublica;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public class EncrypterUtil {

    LlavePublica llavePublica ;
    private    String LLAVE_PUBLICA="";


    private static final String ALGORITMO = "RSA/ECB/PKCS1PADDING";


    public EncrypterUtil() {

    }

    public String ecnriptarUsuario( String cadena) throws Exception  {
        llavePublica = new LlavePublica();

        LLAVE_PUBLICA= llavePublica.llave;

        String encryptedAndEncoded =null ;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, obtenerLlave());
            byte[] encrypted = cipher.doFinal(cadena.getBytes());
            encryptedAndEncoded = encriptBase64(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedAndEncoded;
    }



    public String encriptBase64(byte[]  cadena) {
        String datoencriptadosString = Base64.encodeToString(cadena, Base64.DEFAULT);
        return datoencriptadosString;  // Base64.getEncoder().encodeToString(cadena);
    }


    public PublicKey obtenerLlave() throws Exception {

        String content =LLAVE_PUBLICA;

        System.out.println(content);
        String stringAfter = content
                .replaceAll("\\n", "")
                .replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .trim();

        byte[] decoded = Base64.decode(stringAfter, Base64.DEFAULT) ;

        KeySpec keySpec
                = new X509EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey   publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }



}