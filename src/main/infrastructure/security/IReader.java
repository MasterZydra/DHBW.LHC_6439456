package main.infrastructure.security;

import main.human_resources.Employee;

public interface IReader {
    String scanIris(Employee employee);
    void insertIDCard(IIDCard idCard);
    void removeIDCard();
    boolean verifyPassword(String input);
    IIDCard getCurrentIDCard();
}
