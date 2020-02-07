package main.infrastructure.security;

import main.human_resources.Employee;
import main.human_resources.ISecurityOfficer;

public interface ISecurityCenter {
    void addEmployeeIdCard(IIDCard idCard);
    void lockEmployeeIdCard(Employee employee);
    void setReceptionStaff(ISecurityOfficer securityOfficer);
    ISecurityOfficer getSecurityOfficer();
    IIDCard getBlankIDCard();
    IWriter getWriter();
}
