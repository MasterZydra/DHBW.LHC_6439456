package infrastructure;

import human_resources.IReceptionStaff;
import infrastructure.security.*;

import java.util.Stack;

public enum Reception implements IReception {
    instance;

    private IIDCardManagement idCardManagement;
    private IReceptionStaff receptionStaff;
    private Stack<IIDCard> blankIDCards;
    private IWriter writer;

    Reception() {
        this.idCardManagement = IDCardManagement.instance;
        this.blankIDCards = new Stack<>();
        this.writer = new Writer();
        for (int i = 0; i < 15; i++) {
            this.blankIDCards.add(new VisitorIDCard(Integer.toString(i)));
        }
    }

    public void setReceptionStaff(IReceptionStaff receptionStaff) {
        this.receptionStaff = receptionStaff;
        this.receptionStaff.setReception(this);
    }

    public IReceptionStaff getReceptionStaff() {
        return this.receptionStaff;
    }

    public IIDCard getBlankIDCard() {
        return this.blankIDCards.pop();
    }

    public IWriter getWriter() {
        return this.writer;
    }

    public void addVisitorIDCard(IIDCard idCard) {
        this.idCardManagement.addIDCard(idCard);
    }
}
