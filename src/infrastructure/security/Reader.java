package infrastructure.security;

import human_resources.Employee;

public abstract class Reader implements IReader {
    private String currentEmployeeIris;

    private IIDCardManagement idCardManagement;

    private IIDCard currentIDCard;

    public Reader() {
        this.idCardManagement = IDCardManagement.instance;
    }

    public String scanIris(Employee employee) {
        return "";
    }

    public void insertIDCard(IIDCard idCard) {
        this.currentIDCard = idCard;
    }

    public void removeIDCard() {
        this.currentIDCard = null;
    }

    public abstract boolean verifyPassword(String input);

    protected boolean checkPassword(String input, String cardData) {
        CryptoEngine cryptoEngine = new AESCryptoEngine();
        input = cryptoEngine.encrypt(input);
        return cardData.equals(input);
    }
}
