package main.infrastructure.security;

import java.util.Date;

public class EmployeeReader extends Reader {
    public void insertIDCard(EmployeeIDCard idCard) {
        if (idCard.getIsLocked() || idCard.getValidUntil().compareTo(new Date()) < 0)
        {
            System.out.println("IDCard was denied");
            return;
        }
        this.currentIDCard = idCard;
    }

    public boolean verifyPassword(String input) {
        return this.checkPassword(input, this.currentIDCard.getCommunication().getData());
    }

    @Override
    public void removeIDCard() {
        this.currentIDCard = null;
    }
}
