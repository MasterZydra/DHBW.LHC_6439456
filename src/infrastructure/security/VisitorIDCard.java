package infrastructure.security;

public class VisitorIDCard extends IDCard {
    private IChip passwordChip;

    public VisitorIDCard(String id) {
        super(id);
        this.passwordChip = new Chip();
    }

    public void setPassword(String password) {
        this.passwordChip.setData(password);
        this.communication.setData(password);
    }
}
