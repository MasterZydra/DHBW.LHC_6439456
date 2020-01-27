package infrastructure.security;

import human_resources.Employee;

public interface IReader {
    String scanIris(Employee employee);
    void insertIDCard(IIDCard idCard);
    void removeIDCard();
    boolean verifyPassword(String input);
}
