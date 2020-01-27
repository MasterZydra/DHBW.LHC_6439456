package human_resources;

import infrastructure.security.IDCard;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeManagement implements IEmployeeManagement {
    instance;

    private Map<Integer, Employee> employeeMap;

    private int employeeID;

    EmployeeManagement() {
        this.employeeMap = new HashMap<>();
    }

    public void createEmployee(String name, String type) throws Exception {
        Employee employee;
        switch (type) {
            case "SecurityOfficer":
                employee = new SecurityOfficer(this.employeeID, name);
                break;
            case "Researcher":
                employee = new Researcher(this.employeeID, name);
                break;
            default: throw new Exception("EmployeeManagement: Employee type not supported!");
        }
        this.employeeMap.put(this.employeeID, employee);

        this.employeeID++;
    }

    public void assignIDCard(IDCard idCard, Employee employee) {

    }

    public void viewEmployeeData() {
        this.employeeMap.forEach((k,v) -> {
            System.out.println(v);
        });
    }
}
