package test;

import main.human_resources.IResearchGroup;
import main.human_resources.ResearchGroup;
import main.human_resources.Researcher;
import main.infrastructure.ControlCenter;
import main.infrastructure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExperiment
{
    @Test
    @Order(1)
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
    public void checkSearchAlgorithms()
    {

    }


    @Test
    @Order(3)
    public void initializeRing()
    {

    }

    @Test
    @Order(4)
    public void initProtonTraps()
    {

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
    public void checkExperimentBlocks()
    {

    }

}
