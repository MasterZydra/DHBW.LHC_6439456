package infrastructure.security;

public interface IIDCardManagement {
    void lockIDCard(IDCard idCard);
    void clearIDCard(IDCard idCard);
}
