package human_resources;

public class HRAssistant extends Employee {
    private IROEmployeeManagement employeeManagement;

    public HRAssistant(int id, String name) {
        super(id, name);
        this.employeeManagement = EmployeeManagement.instance;
    }

    public IROEmployeeManagement getEmployeeManagement() {
        return this.employeeManagement;
    }
}
