package lhs.gpa.calculator.backend;

import java.io.File;

public class CryptoUtilsTest {
    public static void main(String[] args) throws Exception {
        String key           = Password.getSaltedHash("Mary has a little lamb");
        File   inputFile     = new File("document.txt");
        File   encryptedFile = new File("document.encrypted");
        File   decryptedFile = new File("document.decrypted");
        
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}