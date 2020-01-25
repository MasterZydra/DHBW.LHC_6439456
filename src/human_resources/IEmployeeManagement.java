package human_resources;

import infrastructure.security.IDCard;

public interface IEmployeeManagement extends IROEmployeeManagement {
    void createEmployee(String name);
    void assignIDCard(IDCard idCard, Employee employee);
}
