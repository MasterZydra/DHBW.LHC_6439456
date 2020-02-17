package test;

import main.human_resources.*;
import main.infrastructure.*;
import main.infrastructure.security.*;
import org.junit.jupiter.api.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: 8093702
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestIDCard
{
    private Employee employee;

    @BeforeEach
    public void init()
    {
        ISecurityCenter securityCenter = SecurityCenter.instance;
        ISecurityOfficer securityOfficer = new SecurityOfficer(0, "Sigi Sischerheitsmann");

        securityCenter.setReceptionStaff(securityOfficer);

        employee = new ScientificAssistant(1, "Anton Assistent");

        ISecurityOfficer securityOfficer1 = securityCenter.getSecurityOfficer();
        securityOfficer1.createIDCard(employee, EmployeeType.SCIENTIFIC_ASSISTANT);
    }

    @Test
    @Order(1)
    @DisplayName("Check if visitor id card is created correctly")
    public void visitorIDCardCreated()
    {
        IReception reception = Reception.instance;
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Renate Rezeptionist");

        reception.setReceptionStaff(receptionStaff);

        Visitor visitor = new Visitor(1, "Bernd Besucher");

        IReceptionStaff receptionStaff1 = reception.getReceptionStaff();
        receptionStaff1.createIDCard(visitor);

        VisitorIDCard idCard = (VisitorIDCard) visitor.getIdCard();

        assertEquals(idCard.getPerson(), visitor);
        assertEquals(idCard.getIrisStructure(), visitor.getIris());
        assertEquals(idCard.getIsLocked(), false);

        assertNotEquals(idCard.getPermissionList(), null);
        assertEquals(idCard.getPermissionList().get(0), Permission.Visitor);

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        assertEquals(format.format(idCard.getValidFrom()), format.format(new Date()));
        assertEquals(format.format(idCard.getValidUntil()), format.format(new Date(idCard.getValidFrom().getTime() + (1000 * 60 * 60 * 24))));
    }

    @Test
    @Order(2)
    @DisplayName("Check if employee id card is created correctly")
    public void employeeIDCardCreated()
    {
        EmployeeIDCard idCard = (EmployeeIDCard) employee.getIdCard();
        assertEquals(idCard.getPerson(), employee);
        assertEquals(idCard.getIrisStructure(), employee.getIris());
        assertEquals(idCard.getIsLocked(), false);

        assertNotEquals(idCard.getPermissionList(), null);
        assertEquals(idCard.getPermissionList().get(0), Permission.ControlCenter);

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        assertEquals(format.format(idCard.getValidFrom()), format.format(new Date()));
        assertEquals(format.format(idCard.getValidUntil()), format.format(new Date(idCard.getValidFrom().getTime() + (1000 * 60 * 60 * 24 * 365))));
    }

    @Test
    @Order(3)
    @DisplayName("lock ID Card if password is wrong three times")
    public void lockIDCard()
    {
        EmployeeReader reader = new EmployeeReader();
        reader.insertIDCard((EmployeeIDCard) employee.getIdCard());
        reader.verifyPassword("helloLHC20201");
        reader.verifyPassword("helloLHC20201");
        reader.verifyPassword("helloLHC20201");

        assertEquals(employee.getIdCard().getIsLocked(), true);
        reader.removeIDCard();
    }

    @Test
    @Order(4)
    @DisplayName("Locked IDCard was denied")
    public void rejectLockedIDCard()
    {
        EmployeeReader reader = new EmployeeReader();
        employee.getIdCard().setIsLocked(true);

        reader.insertIDCard(employee.getIdCard());
        assertEquals(reader.getCurrentIDCard(), null);
    }

    @Test
    @Order(5)
    @DisplayName("Expired IDCard was denied")
    public void rejectExpiredIDCard()
    {
        EmployeeReader reader = new EmployeeReader();
        employee.getIdCard().setValidUntil(new Date(new Date().getTime() - (1000 * 60 * 60 * 24)));

        reader.insertIDCard(employee.getIdCard());
        assertEquals(reader.getCurrentIDCard(), null);
    }
}
