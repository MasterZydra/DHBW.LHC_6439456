package infrastructure.security;

public class VisitorReader extends Reader {
    private VisitorIDCard currentVisitorIDCard;

    public void insertIDCard(VisitorIDCard idCard) {
        this.currentVisitorIDCard = idCard;
    }

    public boolean verifyPassword(String input) {
        return this.checkPassword(input, this.currentVisitorIDCard.getCommunication().getData());
    }

    @Override
    public void removeIDCard() {
        this.currentVisitorIDCard = null;
    }
}
