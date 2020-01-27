package human_resources;

public abstract class Employee extends Person {
    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;

    public Employee(int id, String name) {
        super(id, name);
    }
}
