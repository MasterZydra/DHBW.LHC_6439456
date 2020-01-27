package infrastructure.security;

import human_resources.Employee;

import java.util.HashMap;
import java.util.Map;

public enum IDCardManagement implements IIDCardManagement {
    instance;

    private Map<Integer, IIDCard> idCardHashMap;

    private IReader reader;

    IDCardManagement() {
        this.idCardHashMap = new HashMap<>();
    }

    public void lockIDCard(Employee employee) {
        this.idCardHashMap.forEach((k,v) -> {
            if (v.getPerson().equals(employee)) {
                v.setIsLocked(Boolean.TRUE);
                return;
            }
        });
    }

    public void clearIDCard(IIDCard idCard) {

    }

    public void addIDCard(IIDCard idCard) {
        this.idCardHashMap.put(Integer.parseInt(idCard.getId()), idCard);
    }
}
