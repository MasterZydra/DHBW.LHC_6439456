package main.infrastructure.security;

import main.human_resources.IPerson;

import java.util.ArrayList;
import java.util.Date;

public interface IIDCard extends IROIDCard {
    IPerson getPerson();
    void setValidFrom(Date date);
    void setValidUntil(Date date);
    void setIrisStructure(int[][] irisStructure);
    void setPermissionList(ArrayList<Permission> permissionList);
    void setPassword(String password);
    void setPerson(IPerson person);
    void setIsLocked(Boolean isLocked);
    public ICommunication getCommunication();
    public void setCommunication(ICommunication communication);
    Date getValidFrom();
    Date getValidUntil();
    int[][] getIrisStructure();
    boolean getIsLocked();
    ArrayList<Permission> getPermissionList();
    void increaseInvalidPasswordCounter();
    void resetInvalidPasswordCounter();
    int getInvalidPasswordCounter();
}
