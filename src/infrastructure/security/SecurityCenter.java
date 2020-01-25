package infrastructure.security;

import human_resources.IROEmployeeManagement;

public enum SecurityCenter implements ISecurityCenter {
    instance;

    private IIDCardManagement idCardManagement;
    private IROEmployeeManagement employeeManagement;

    public void createEmployeeIdCard() {

    }

    public void lockEmployeeIdCard() {

    }
}
