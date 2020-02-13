package main.human_resources;

import main.infrastructure.security.ISecurityCenter;

public interface ISecurityOfficer {
    void createIDCard(Employee employee, EmployeeType type);
    void setSecurityCenter(ISecurityCenter securityCenter);
}
