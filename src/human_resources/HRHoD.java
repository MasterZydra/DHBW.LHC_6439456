package human_resources;

public class HRHoD extends Employee {
    private IEmployeeManagement employeeManagement;

    public HRHoD(int id, String name) {
        super(id, name);
        this.employeeManagement = EmployeeManagement.instance;
    }
}
