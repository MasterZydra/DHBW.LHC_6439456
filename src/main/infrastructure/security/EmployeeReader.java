package main.infrastructure.security;

import java.util.Date;

public class EmployeeReader extends Reader {
    private EmployeeIDCard currentEmployeeIDCard; // TODO: löschen

    public void insertIDCard(EmployeeIDCard idCard) {
        if (idCard.getIsLocked() || idCard.getValidUntil().compareTo(new Date()) < 0)
        {
            System.out.println("IDCard was denied");
            return;
        }
        this.currentEmployeeIDCard = idCard;
        this.currentIDCard = idCard;
    }

    public boolean verifyPassword(String input) {
        return this.checkPassword(input, this.currentEmployeeIDCard.getCommunication().getData());
    }

    @Override
    public void removeIDCard() {
        this.currentEmployeeIDCard = null;
        this.currentIDCard = null;
    }
}
