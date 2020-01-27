package infrastructure.security;

import human_resources.Person;

public class EmployeeIDCard extends IDCard {
    private IChip fingerPrintChip;
    private IChip passwordChip;

    public EmployeeIDCard(String id) {
        super(id);
        this.fingerPrintChip = new Chip();
        this.passwordChip = new Chip();
    }

    public String getData() {
        return this.passwordChip.toString();
    }

    public void setPassword(String password) {
        this.passwordChip.setData(password);
    }
}
