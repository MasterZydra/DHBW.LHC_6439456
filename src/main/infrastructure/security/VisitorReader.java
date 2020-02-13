package main.infrastructure.security;

import java.util.Date;

public class VisitorReader extends Reader {
    private VisitorIDCard currentVisitorIDCard;

    public void insertIDCard(VisitorIDCard idCard) {
        if (idCard.getIsLocked() || idCard.getValidUntil().compareTo(new Date()) < 0)
        {
            System.out.println("IDCard was denied");
            return;
        }
        this.currentIDCard = idCard;
        this.currentVisitorIDCard = idCard;
    }

    public boolean verifyPassword(String input) {
        return this.checkPassword(input, this.currentVisitorIDCard.getCommunication().getData());
    }

    @Override
    public void removeIDCard() {
        this.currentVisitorIDCard = null;
        this.currentIDCard = null;
    }
}
