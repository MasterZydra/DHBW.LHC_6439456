package human_resources;

import infrastructure.security.IDCard;
import infrastructure.security.IReader;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeManagement implements IEmployeeManagement {
    instance;

    private Map<Integer, Employee> employeeMap;

    EmployeeManagement() {
        this.employeeMap = new HashMap<>();
    }

    public void createEmployee(String name) {

    }

    public void assignIDCard(IDCard idCard, Employee employee) {

    }

    public void viewEmployeeData() {

    }
}
