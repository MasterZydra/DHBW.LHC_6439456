package infrastructure.security;

import infrastructure.Configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AESCryptoEngine extends CryptoEngine {
    private Key secretKey;

    // Source for code: https://blog.axxg.de/java-aes-verschluesselung-mit-beispiel/

    public AESCryptoEngine() {
        this.generateSecretKey();
    }

    private void generateSecretKey() {
        try {
            byte[] key = (Configuration.instance.AESKey).getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            this.secretKey = new SecretKeySpec(key, "AES");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    String encrypt(String rawData) {
        try {
            // Encode
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
            byte[] encrypted = cipher.doFinal(rawData.getBytes());
            // Bytes to Base64-String
            return Base64.getEncoder().encodeToString(encrypted);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    String decrypt(String hashData) {
        try {
            // Base64-String to Bytes
            byte[] crypted = Base64.getDecoder().decode(hashData);
            // Decode
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
            byte[] cipherData2 = cipher.doFinal(crypted);
            return new String(cipherData2);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
