package infrastructure.security;

import human_resources.Employee;
import human_resources.ISecurityOfficer;

public interface ISecurityCenter {
    void addEmployeeIdCard(IIDCard idCard);
    void lockEmployeeIdCard(Employee employee);
    void setReceptionStaff(ISecurityOfficer securityOfficer);
    ISecurityOfficer getSecurityOfficer();
    IIDCard getBlankIDCard();
    IWriter getWriter();
}
