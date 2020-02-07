package main.infrastructure.security;

import main.human_resources.Employee;

public interface IIDCardManagement {
    void lockIDCard(Employee employee);
    void clearIDCard(IIDCard idCard);
    void addIDCard(IIDCard idCard);
}
