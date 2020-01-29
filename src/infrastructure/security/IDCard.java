package infrastructure.security;

import human_resources.Person;

import java.util.ArrayList;
import java.util.Date;

public abstract class IDCard implements IIDCard {
    private String id;
    private Date validFrom;
    private Date validUntil;
    private int[][] irisStructure = new int[10][10];;
    private ArrayList<Permission> permissionList;
    private boolean isLocked;
    protected ICommunication communication;

    private Person person;

    public IDCard(String id) {
        this.id = id;
        this.communication = new RFID();
    }

    public String getId() {
        return this.id;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setValidFrom(Date date) {
        this.validFrom = date;
    }

    public void setValidUntil(Date date) {
        this.validUntil = date;
    }

    public void setIrisStructure(int[][] irisStructure) {
        this.irisStructure = irisStructure;
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public ICommunication getCommunication() {
        return this.communication;
    }

    public void setCommunication(ICommunication communication) {
        this.communication = communication;
    }
}
