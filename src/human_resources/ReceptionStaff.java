package human_resources;

import infrastructure.IReception;
import infrastructure.security.*;

import java.util.ArrayList;
import java.util.Date;

public class ReceptionStaff extends Employee implements IReceptionStaff {
    private IReception reception;
    private IIDCard currentIDCard;
    private Visitor currentVisitor;

    public ReceptionStaff(int id, String name) {
        super(id, name);
    }

    public void createIDCard(Visitor visitor) {
        this.currentVisitor = visitor;
        this.currentIDCard = this.reception.getBlankIDCard();

        Date validFrom = new Date();
        Date validUntil = new Date(validFrom.getTime() + (1000 * 60 * 60 * 24));

        ArrayList<Permission> permissions = new ArrayList<>();
        permissions.add(Permission.Visitor);

        IWriter writer = this.reception.getWriter();
        writer.setIDCard(this.currentIDCard);
        writer.setValidFrom(validFrom);
        writer.setValidUntil(validUntil);
        writer.setIrisStructure(this.currentVisitor.iris);
        writer.setPermissionList(permissions);
        writer.setPassword(this.currentVisitor.enterPassword());

        this.reception.addVisitorIDCard(this.currentIDCard);

        this.giveIDCard();
    }

    public void giveIDCard() {
        this.currentVisitor.setIDCard(this.currentIDCard);
        this.currentIDCard = null;
        this.currentVisitor = null;
    }

    public void setReception(IReception reception) {
        this.reception = reception;
    }
}
