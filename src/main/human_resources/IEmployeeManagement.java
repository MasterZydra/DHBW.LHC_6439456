package main.human_resources;

import main.infrastructure.security.IDCard;

public interface IEmployeeManagement extends IROEmployeeManagement {
    void createEmployee(String name, String type) throws Exception;
    void assignIDCard(IDCard idCard, Employee employee);
}
