package infrastructure.security;

import human_resources.Person;

import java.util.ArrayList;
import java.util.Date;

public interface IIDCard extends IROIDCard {
    Person getPerson();
    void setValidFrom(Date date);
    void setValidUntil(Date date);
    void setIrisStructure(int[][] irisStructure);
    void setPermissionList(ArrayList<Permission> permissionList);
    void setPassword(String password);
    void setPerson(Person person);
    void setIsLocked(Boolean isLocked);
    public ICommunication getCommunication();
    public void setCommunication(ICommunication communication);
}
