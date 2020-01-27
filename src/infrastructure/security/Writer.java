package infrastructure.security;

import java.util.ArrayList;
import java.util.Date;

public class Writer implements IWriter {
    private IIDCard idCard;
    CryptoEngine cryptoEngine = new AESCryptoEngine();

    public void setIDCard(IIDCard idCard) {
        this.idCard = idCard;
    }

    public void setValidFrom(Date date) {
        this.idCard.setValidFrom(date);
    }

    public void setValidUntil(Date date) {
        this.idCard.setValidUntil(date);
    }

    public void setIrisStructure(int[][] irisStructure) {
        this.idCard.setIrisStructure(irisStructure);
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        this.idCard.setPermissionList(permissionList);
    }

    public void setPassword(String password) {
        this.idCard.setPassword(cryptoEngine.encrypt(password));
    }

    public void setIsLocked(Boolean isLocked) {
        this.idCard.setIsLocked(isLocked);
    }
}
