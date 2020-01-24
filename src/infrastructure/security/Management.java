package infrastructure.security;

import human_resources.Employee;
import infrastructure.security.IDCard;
import infrastructure.security.Reader;

import java.util.HashMap;

public enum Management {
    instance;

    private HashMap<Integer, Employee> employeeMap;
    private HashMap<Integer, IDCard> idCardHashMap;

    private Reader reader;

    Management() {
        this.employeeMap = new HashMap<>();
        this.idCardHashMap = new HashMap<>();
    }

    public void createEmployee(String name) {

    }

    public void assignIDCard(IDCard idCard, Employee employee) {

    }

    public void lockIDCard(IDCard idCard) {

    }

    public void clearIDCard(IDCard idCard) {

    }
}
