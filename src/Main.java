import main.human_resources.*;
import main.infrastructure.*;
import main.infrastructure.energy.*;
import main.infrastructure.lhc.*;
import main.infrastructure.lhc.detector.*;
import main.infrastructure.lhc.experiment.*;
import main.infrastructure.security.*;

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
        buildEnvironment();
        createDB();
    }

    public static void createDB() {
        System.out.println("\n---------- createDB() ----------");
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);

        Detector detector = new Detector();

        Ring ring = new Ring();
        ring.setProtonTraps(protonTrap1, protonTrap2);
        ring.setDetector(detector);

        ControlCenter controlCenter = ControlCenter.instance;

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(50, ExperimentScope.ES5);

        DataBaseManager dbMan = new DataBaseManager();
        dbMan.setupConnection();
        dbMan.createEmployeeTable();
        dbMan.createExperimentTable();
        dbMan.createIDCardTable();

        detector.getExperimentList().forEach((e) -> {
            dbMan.insertExperiment(e);
        });
    }

    public static void buildEnvironment() {
        try {
            IBuilding building = new Building();
            ILargeHadronCollider largeHadronCollider = new LargeHadronCollider();
            building.setLargeHadronCollider(largeHadronCollider);
            largeHadronCollider.setBuilding(building);

            IRing ring = new Ring();
            ring.setLargeHadronCollider(largeHadronCollider);
            largeHadronCollider.setRing(ring);

            IUSP usp1 = new USP();
            IUSP usp2 = new USP();
            largeHadronCollider.setUSPs(usp1, usp2);

            Battery[] batteries1 = new Battery[25];
            for (int i = 0; i < 25; i++) {
                batteries1[i] = new Battery();
            }
            Battery[] batteries2 = new Battery[25];
            for (int i = 0; i < 25; i++) {
                batteries2[i] = new Battery();
            }

            usp1.setBatteries(batteries1);
            usp2.setBatteries(batteries2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        securityOfficer1.createIDCard(employee, EmployeeType.SCIENTIFIC_ASSISTANT);
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
        securityOfficer1.createIDCard(employee, EmployeeType.SCIENTIFIC_ASSISTANT);
        securityOfficer1.createIDCard(employee1, EmployeeType.DEFAULT_EMPLOYEE);

        securityCenter.lockEmployeeIdCard(employee);
    }

    public static void readerCheckAccessForEmployee() {
        System.out.println("\n---------- readerCheckAccessForEmployee() ----------");
        ISecurityCenter securityCenter = SecurityCenter.instance;
        ISecurityOfficer securityOfficer = new SecurityOfficer(0, "Sigi Sischerheitsmann");

        securityCenter.setReceptionStaff(securityOfficer);

        Employee employee = new ScientificAssistant(1, "Anton Assistent");

        ISecurityOfficer securityOfficer1 = securityCenter.getSecurityOfficer();
        securityOfficer1.createIDCard(employee, EmployeeType.SCIENTIFIC_ASSISTANT);

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
        controlCenter.startExperiment(50);

        // Test output
        //detector.viewExperiments();
    }
}
