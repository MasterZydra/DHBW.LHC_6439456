package infrastructure.security;

public abstract class CryptoEngine {
    abstract String encrypt(String rawData);
    abstract String decrypt(String hashData);
}
