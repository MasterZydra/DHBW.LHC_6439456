package test;

import main.infrastructure.lhc.experiment.*;
import main.human_resources.*;
import main.infrastructure.*;
import main.infrastructure.lhc.*;
import main.infrastructure.lhc.detector.*;

/*
 * Author: 8093702
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExperiment
{
    @Test
    @Order(1)
    @DisplayName("Check Control Centre")
    public void checkControlCentre()
    {
        IResearchGroup group1 = new ResearchGroup(new Researcher(1, "Richard Researcher"));
        IWorkplace workplace1 = new Workplace();
        workplace1.setResearchGroup(group1);

        IResearchGroup group2 = new ResearchGroup(new Researcher(2, "Renate Researcher"));
        IWorkplace workplace2 = new Workplace();
        workplace2.setResearchGroup(group2);

        IResearchGroup group3 = new ResearchGroup(new Researcher(3, "Rudolf Researcher"));
        IWorkplace workplace3 = new Workplace();
        workplace3.setResearchGroup(group3);

        ControlCenter.instance.setWorkplaces(new IWorkplace[]{workplace1, workplace2, workplace3});

        IWorkplace[] controlCentreWorkplaces = ControlCenter.instance.getWorkplaces();
        assertNotNull(controlCentreWorkplaces);
        assertEquals(controlCentreWorkplaces.length, 3);
        for (int i = 0; i < 3; i++)
        {
            assertNotNull(controlCentreWorkplaces[i]);
            assertNotNull(controlCentreWorkplaces[i].getResearchGroup());
            assertTrue(controlCentreWorkplaces[i].getResearchGroup().getResearchers().size() > 0);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check search algorithms")
    public void checkSearchAlgorithms()
    {
        Detector detector = new Detector();
        Configuration.instance.searchAlgorithm = SearchAlgorithm.Native;
        detector.receive(new AnalyseEvent());
        assertNotNull(detector.getPort());

        detector = new Detector();
        Configuration.instance.searchAlgorithm = SearchAlgorithm.BoyerMoore;
        detector.receive(new AnalyseEvent());
        assertNotNull(detector.getPort());

        detector = new Detector();
        Configuration.instance.searchAlgorithm = SearchAlgorithm.KnuthMorrisPratt;
        detector.receive(new AnalyseEvent());
        assertNotNull(detector.getPort());
    }


    @Test
    @Order(3)
    @DisplayName("TODO")
    public void initializeRing()
    {
        /*
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);

        Detector detector = new Detector();

        Ring ring = new Ring();
        ring.setProtonTraps(protonTrap1, protonTrap2);
        ring.setDetector(detector);

        ControlCenter controlCenter = ControlCenter.instance;

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(energy, scope);
        */
    }

    @Test
    @Order(4)
    @DisplayName("Check if protons are filled correctly")
    public void initProtonTraps()
    {
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);

        IProton proton1;
        IProton proton2;

        for (int i = 0; i < 25; i++)
        {
            proton1 = protonTrap1.release();
            assertNotNull(proton1);
            int[][][] proton1Structure = proton1.getStructure();
            assertEquals(proton1Structure.length, 100);

            proton2 = protonTrap2.release();
            assertNotNull(proton2);
            int[][][] proton2Structure = proton2.getStructure();
            assertEquals(proton2Structure.length, 100);

            for (int j = 0; j <100 ; j++)
            {
                assertEquals(proton1Structure[j].length, 100);
                assertEquals(proton2Structure[j].length, 100);

                for (int k = 0; k < 100; k++)
                {
                    assertEquals(proton1Structure[j][k].length, 100);
                    assertEquals(proton2Structure[j][k].length, 100);
                }
            }
        }
    }

    @Test
    @Order(5)
    public void takeProtonFromProtontrap()
    {

    }

    @Test
    @Order(6)
    public void collideProtons()
    {

    }

    @Test
    @Order(7)
    @DisplayName("Check if blocks are filled correctly")
    public void checkExperimentBlocks()
    {
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

        IExperiment experiment = detector.getExperimentList().get(0);

        for (int i = 0; i < 200000; i++)
        {
            assertEquals(experiment.getBlock(i).getStructure().length(), 10);
        }

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> experiment.getBlock(200000));
    }

}
