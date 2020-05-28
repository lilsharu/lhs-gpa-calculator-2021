package lhs.gpa.calculator.backend;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class CryptoUtils {
    public static OutputStream encryptFile(InputStream toEncrypt, String password)
            throws NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException {
        SecureRandom srandom = SecureRandom.getInstance("SHA1PRNG");
        
        byte[] salt = new byte[8];
        srandom.nextBytes(salt);
        SecretKeyFactory factory =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec skey = new SecretKeySpec(tmp.getEncoded(), "AES");
    
        byte[] iv = new byte[128/8];
        srandom.nextBytes(iv);
        IvParameterSpec ivspec = new IvParameterSpec(iv);
    
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(salt);
        out.write(iv);
    
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.ENCRYPT_MODE, skey, ivspec);
    
        try  {
            processFile(ci, toEncrypt, out);
        }
        catch (Exception e) {
            System.err.println("File Processing Failed");
            throw e;
        }
        
        return out;
    }
    
    public static InputStream decryptFile(InputStream toDecrypt, String password)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        byte[] salt = new byte[8], iv = new byte[128/8];
        toDecrypt.read(salt);
        toDecrypt.read(iv);
    
        SecretKeyFactory factory =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec skey = new SecretKeySpec(tmp.getEncoded(), "AES");
    
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.DECRYPT_MODE, skey, new IvParameterSpec(iv));
    
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try  {
            processFile(ci, toDecrypt, out);
        }
        catch (Exception e) {
            System.err.println("File Decryption Failed");
            throw e;
        }
        
        return new ByteArrayInputStream(out.toByteArray());
    }
    
    static private void processFile(Cipher ci,InputStream in,OutputStream out)
            throws javax.crypto.IllegalBlockSizeException,
            javax.crypto.BadPaddingException,
            java.io.IOException
    {
        byte[] inputBuffer = new byte[1024];
        int len;
        while ((len = in.read(inputBuffer)) != -1) {
            byte[] outputBuffer = ci.update(inputBuffer, 0, len);
            if ( outputBuffer != null ) out.write(outputBuffer);
        }
        byte[] obuf = ci.doFinal();
        if ( obuf != null ) out.write(obuf);
    }
}
