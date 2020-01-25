package infrastructure.security;

import human_resources.Employee;

public interface IReader {
    String scanPassport(Passport passport);
    String scanIris(Employee employee);
    void insertIDCard(IDCard idCard);
    void removeIDCard();
}
