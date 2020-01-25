package infrastructure.security;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5HashEngine extends HashEngine {
    @Override
    String hash(String rawData) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(rawData.getBytes());
            return Base64.getEncoder().encodeToString(messageDigest);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
