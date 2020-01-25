package infrastructure.security;

public abstract class HashEngine {
    abstract String hash(String rawData);
}
