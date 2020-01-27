package human_resources;

public class HRConsultant extends Employee {
    private IEmployeeManagement employeeManagement;

    public HRConsultant(int id, String name) {
        super(id, name);
        this.employeeManagement = EmployeeManagement.instance;
    }
}
