import human_resources.*;
import infrastructure.*;
import infrastructure.lhc.*;
import infrastructure.lhc.detector.*;
import infrastructure.lhc.experiment.*;
import infrastructure.security.*;

public class Main {
    public static void main(String[] args) {
        createVisitorIDCard();
        createEmployeeIDCard();
        researcherAccessesDetector();
        hrAssistantAccessesEmployeeData();
        lockIDCard();
        readerCheckAccessForVisitor();
        readerCheckAccessForEmployee();
        eventBusTest();
    }

    public static void createVisitorIDCard() {
        // Erstellung einer ID-Karte für Besucher durch die Rezeption
        IReception reception = Reception.instance;
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Renate Rezeptionist");

        reception.setReceptionStaff(receptionStaff);

        Visitor visitor = new Visitor(1, "Bernd Besucher");

        IReceptionStaff receptionStaff1 = reception.getReceptionStaff();
        receptionStaff1.createIDCard(visitor);
    }

    public static void createEmployeeIDCard() {
        ISecurityCenter securityCenter = SecurityCenter.instance;
        ISecurityOfficer securityOfficer = new SecurityOfficer(0, "Sigi Sischerheitsmann");

        securityCenter.setReceptionStaff(securityOfficer);

        Employee employee = new ScientificAssistant(1, "Anton Assistent");

        ISecurityOfficer securityOfficer1 = securityCenter.getSecurityOfficer();
        securityOfficer1.createIDCard(employee);
    }

    public static void researcherAccessesDetector() {
        System.out.println("\n---------- researcherAccessesDetector() ----------");
        Detector detector = new Detector();
        for (int i = 0; i < 10; i++) {
            Experiment exp = new Experiment();
            detector.addExperiment(exp);
        }

        Employee employee = new Researcher(0, "Freddy Forscher");
        ((Researcher) employee).setDetector(detector);
        ((Researcher) employee).getDetector().viewExperiments();
    }

    public static void hrAssistantAccessesEmployeeData() {
        System.out.println("\n---------- hrAssistantAccessesEmployeeData() ----------");
        IEmployeeManagement employeeManagement = EmployeeManagement.instance;
        try {
            employeeManagement.createEmployee("Rudolf Researcher", "Researcher");
            employeeManagement.createEmployee("Sandra Sicherheit", "SecurityOfficer");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HRAssistant hrAssistant = new HRAssistant(123, "Peter Personaler");
        hrAssistant.getEmployeeManagement().viewEmployeeData();
    }

    public static void lockIDCard() {
        ISecurityCenter securityCenter = SecurityCenter.instance;
        ISecurityOfficer securityOfficer = new SecurityOfficer(0, "Sigi Sischerheitsmann");

        securityCenter.setReceptionStaff(securityOfficer);

        Employee employee = new ScientificAssistant(1, "Anton Assistent");
        Employee employee1 = new HRAssistant(2, "Peter Personaler");

        ISecurityOfficer securityOfficer1 = securityCenter.getSecurityOfficer();
        securityOfficer1.createIDCard(employee);
        securityOfficer1.createIDCard(employee1);

        securityCenter.lockEmployeeIdCard(employee);
    }

    public static void readerCheckAccessForEmployee() {
        System.out.println("\n---------- readerCheckAccessForEmployee() ----------");
        ISecurityCenter securityCenter = SecurityCenter.instance;
        ISecurityOfficer securityOfficer = new SecurityOfficer(0, "Sigi Sischerheitsmann");

        securityCenter.setReceptionStaff(securityOfficer);

        Employee employee = new ScientificAssistant(1, "Anton Assistent");

        ISecurityOfficer securityOfficer1 = securityCenter.getSecurityOfficer();
        securityOfficer1.createIDCard(employee);

        EmployeeReader reader = new EmployeeReader();
        reader.insertIDCard((EmployeeIDCard) employee.getIdCard());
        if (reader.verifyPassword("helloLHC2020")) {
            System.out.println("Verified");
        }
        else {
            System.out.println("NOT verified");
        }
        if (reader.verifyPassword("helloLHC20201")) {
            System.out.println("Verified");
        }
        else {
            System.out.println("NOT verified");
        }
        reader.removeIDCard();
    }

    public static void readerCheckAccessForVisitor() {
        System.out.println("\n---------- readerCheckAccessForVisitor() ----------");
        // Create visitor ID card
        IReception reception = Reception.instance;
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Renate Rezeptionist");

        reception.setReceptionStaff(receptionStaff);

        Visitor visitor = new Visitor(1, "Bernd Besucher");

        IReceptionStaff receptionStaff1 = reception.getReceptionStaff();
        receptionStaff1.createIDCard(visitor);

        VisitorReader reader = new VisitorReader();
        reader.insertIDCard((VisitorIDCard) visitor.getIdCard());
        if (reader.verifyPassword("12345")) {
            System.out.println("Verified");
        }
        else {
            System.out.println("NOT verified");
        }
        if (reader.verifyPassword("22345")) {
            System.out.println("Verified");
        }
        else {
            System.out.println("NOT verified");
        }
        reader.removeIDCard();
    }

    public static void eventBusTest() {
        System.out.println("\n---------- eventBusTest() ----------");
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);

        Detector detector = new Detector();

        Ring ring = new Ring();
        ring.setProtonTraps(protonTrap1, protonTrap2);
        ring.setDetector(detector);

        ControlCenter controlCenter = ControlCenter.instance;

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        //controlCenter.startExperiment(ExperimentScope.ESFull);
        controlCenter.startExperiment();

        // Test output
        //detector.viewExperiments();
    }
}
