package infrastructure.security;

import human_resources.*;

import java.util.Stack;

public enum SecurityCenter implements ISecurityCenter {
    instance;

    private IIDCardManagement idCardManagement;
    private IROEmployeeManagement employeeManagement;
    private Stack<IIDCard> blankIDCards;
    private IWriter writer;

    private ISecurityOfficer securityOfficer;

    SecurityCenter() {
        this.idCardManagement = IDCardManagement.instance;
        this.blankIDCards = new Stack<>();
        this.writer = new Writer();
        for (int i = 100; i < 115; i++) {
            this.blankIDCards.add(new EmployeeIDCard(Integer.toString(i)));
        }
    }

    public void addEmployeeIdCard(IIDCard idCard) {
        this.idCardManagement.addIDCard(idCard);
    }

    public void lockEmployeeIdCard(Employee employee) {
        this.idCardManagement.lockIDCard(employee);
    }

    public void setReceptionStaff(ISecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
        this.securityOfficer.setSecurityCenter(this);
    }

    public ISecurityOfficer getSecurityOfficer() {
        return this.securityOfficer;
    }

    public IIDCard getBlankIDCard() {
        return this.blankIDCards.pop();
    }

    public IWriter getWriter() {
        return this.writer;
    }
}
