package infrastructure.security;

import human_resources.Employee;
import infrastructure.security.IDCard;

public class Reader implements IReader {
    private String currentEmployeeIris;

    private IIDCardManagement idCardManagement;

    public String scanPassport(Passport passport) {
        return "";
    }

    public String scanIris(Employee employee) {
        return "";
    }

    public void insertIDCard(IDCard idCard) {

    }

    public void removeIDCard() {

    }
}
