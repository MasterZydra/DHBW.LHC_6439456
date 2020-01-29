package infrastructure.security;

public class EmployeeReader extends Reader {
    private EmployeeIDCard currentEmployeeIDCard;

    public void insertIDCard(EmployeeIDCard idCard) {
        this.currentEmployeeIDCard = idCard;
    }

    public boolean verifyPassword(String input) {
        return this.checkPassword(input, this.currentEmployeeIDCard.getCommunication().getData());
    }

    @Override
    public void removeIDCard() {
        this.currentEmployeeIDCard = null;
    }
}
