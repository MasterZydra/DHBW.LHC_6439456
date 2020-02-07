package main.human_resources;

import main.infrastructure.security.*;

import java.util.ArrayList;
import java.util.Date;

public class SecurityOfficer extends Employee implements ISecurityOfficer {
    private boolean hasWeapon;

    private IIDCard currentIDCard;

    private ISecurityCenter securityCenter;

    public SecurityOfficer(int id, String name) {
        super(id, name);
    }

    public void createIDCard(Employee employee, EmployeeType type) {
        this.currentIDCard = this.securityCenter.getBlankIDCard();

        Date validFrom = new Date();
        Date validUntil = new Date(validFrom.getTime() + (1000 * 60 * 60 * 24 * 365));

        ArrayList<Permission> permissions = new ArrayList<>();
        switch (type) {
            case SECURITY_OFFICER:
                permissions.add(Permission.ControlCenter);
                permissions.add(Permission.Security);
                break;
            case SCIENTIFIC_ASSISTANT:
                permissions.add(Permission.ControlCenter);
                break;
            case RESEARCHER:
                permissions.add(Permission.ControlCenter);
                permissions.add(Permission.Researcher);
                break;
        }

        IWriter writer = this.securityCenter.getWriter();
        writer.setIDCard(this.currentIDCard);
        writer.setValidFrom(validFrom);
        writer.setValidUntil(validUntil);
        writer.setIrisStructure(employee.iris);
        writer.setPermissionList(permissions);
        writer.setPassword("helloLHC2020");
        // TODO Fingerprint
        employee.setIDCard(this.currentIDCard);

        this.securityCenter.addEmployeeIdCard(this.currentIDCard);
        this.currentIDCard = null;
    }

    public void setSecurityCenter(ISecurityCenter securityCenter) {
        this.securityCenter = securityCenter;
    }
}
