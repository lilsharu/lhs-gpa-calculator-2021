package lhs.gpa.calculator.backend;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.KeySpec;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    
    public static OutputStream encryptFile(InputStream toEncrypt, String password)
            throws NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException {
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
    
        FileOutputStream out = new FileOutputStream(toEncrypt + ".enc");
        out.write(salt);
        out.write(iv);
    
        Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ci.init(Cipher.ENCRYPT_MODE, skey, ivspec);
    }
    
    public static void encrypt(String key, File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
    
    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
    
    private static void doCrypto(int cipherMode, String key, File inputFile,
                                 File outputFile) throws CryptoException {
        try {
            Key    secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher    = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
            
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[]          inputBytes  = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            
            byte[] outputBytes = cipher.doFinal(inputBytes);
            
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
            
            inputStream.close();
            outputStream.close();
            
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
}
