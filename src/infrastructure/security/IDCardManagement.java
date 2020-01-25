package infrastructure.security;

import java.util.HashMap;
import java.util.Map;

public enum IDCardManagement implements IIDCardManagement {
    instance;

    private Map<Integer, IDCard> idCardHashMap;

    private IReader reader;

    IDCardManagement() {
        this.idCardHashMap = new HashMap<>();
    }

    public void lockIDCard(IDCard idCard) {

    }

    public void clearIDCard(IDCard idCard) {

    }
}
