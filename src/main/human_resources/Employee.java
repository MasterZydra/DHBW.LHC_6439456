package main.human_resources;

public abstract class Employee extends Person {
    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;

    public Employee(int id, String name) {
        super(id, name);
    }

    public String getDataBaseString() {
        StringBuilder ret = new StringBuilder(Integer.toString(this.id) + ", '" + this.name + "', '");
        for (int i = 0; i < this.iris.length; i++) {
            for (int j = 0; j < this.iris[i].length; j++) {
                ret.append(Integer.toString(this.iris[i][j])).append(",");
            }
        }
        ret.append("', '").append(this.getIdCard().getId()).append("', '");
        ret.append(this.getFingerPrint()).append("'");

        return ret.toString();
    }
}
