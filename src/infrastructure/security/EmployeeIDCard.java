package infrastructure.security;

public class EmployeeIDCard extends IDCard {
    private IChip fingerPrintChip;
    private IChip passwordChip;

    public EmployeeIDCard(String id) {
        super(id);
        this.fingerPrintChip = new Chip();
        this.passwordChip = new Chip();
    }

    public void setPassword(String password) {
        this.passwordChip.setData(password);
        this.communication.setData(password);
    }
}
