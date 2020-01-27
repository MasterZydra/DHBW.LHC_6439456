package human_resources;

import infrastructure.security.ISecurityCenter;

public interface ISecurityOfficer {
    void createIDCard(Employee employee);
    void setSecurityCenter(ISecurityCenter securityCenter);
}
