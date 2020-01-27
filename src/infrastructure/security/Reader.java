package infrastructure.security;

import human_resources.Employee;

public class Reader implements IReader {
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

    public boolean verifyPassword(String input) {
        CryptoEngine cryptoEngine = new AESCryptoEngine();
        input = cryptoEngine.encrypt(input);

        if (this.currentIDCard instanceof VisitorIDCard) {
            VisitorIDCard idCard = (VisitorIDCard) this.currentIDCard;
            return idCard.getData().equals(input);
        }

        if (this.currentIDCard instanceof EmployeeIDCard) {
            EmployeeIDCard idCard = (EmployeeIDCard) this.currentIDCard;
            return idCard.getData().equals(input);
        }

        // Exception
        return false;
    }
}
