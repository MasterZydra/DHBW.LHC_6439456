package main.infrastructure.security;

import main.human_resources.Employee;

import java.util.Date;

public abstract class Reader implements IReader {
    private String currentEmployeeIris;

    private IIDCardManagement idCardManagement;

    protected IIDCard currentIDCard;

    public Reader() {
        this.idCardManagement = IDCardManagement.instance;
    }

    public String scanIris(Employee employee) {
        return "";
    }

    public void insertIDCard(IIDCard idCard) {
        if (idCard.getIsLocked() || idCard.getValidUntil().compareTo(new Date()) < 0)
        {
            System.out.println("IDCard was denied");
            return;
        }
        this.currentIDCard = idCard;
    }

    public void removeIDCard() {
        this.currentIDCard = null;
    }

    public abstract boolean verifyPassword(String input);

    public IIDCard getCurrentIDCard()
    {
        return currentIDCard;
    }

    protected boolean checkPassword(String input, String cardData) {
        if(currentIDCard.getIsLocked())
        {
            return false;
        }

        CryptoEngine cryptoEngine = new AESCryptoEngine();
        input = cryptoEngine.encrypt(input);
        if(cardData.equals(input)) {
            currentIDCard.resetInvalidPasswordCounter();
            return true;
        }
        currentIDCard.increaseInvalidPasswordCounter();
        if(currentIDCard.getInvalidPasswordCounter() >= 3)
        {
            currentIDCard.setIsLocked(true);
        }
        return false;
    }
}
