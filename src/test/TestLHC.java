package test;

import main.infrastructure.energy.*;
import main.infrastructure.lhc.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
* Author: 8093702
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLHC
{
    private ILargeHadronCollider largeHadronCollider;

    @BeforeEach
    public void initLHC()
    {
        try
        {
            // Original code of author 8093702
            /*
            IBuilding building = new Building();
            ILargeHadronCollider lhc = new LargeHadronCollider();
            building.setLargeHadronCollider(lhc);
            lhc.setBuilding(building);

            IRing ring = new Ring();
            ring.setLargeHadronCollider(lhc);
            lhc.setRing(ring);

            IUSP usp1 = new USP();
            IUSP usp2 = new USP();
            lhc.setUSPs(usp1, usp2);

            Battery[] batteries1 = new Battery[25];
            for (int i = 0; i < 25; i++)
            {
                batteries1[i] = new Battery();
            }
            Battery[] batteries2 = new Battery[25];
            for (int i = 0; i < 25; i++)
            {
                batteries2[i] = new Battery();
            }

            usp1.setBatteries(batteries1);
            usp2.setBatteries(batteries2);
             */

            // Fixed code so it works with builder which was added for LHC training
            // Original code below
            IBuilding building = new Building();
            IRing ring = new Ring();
            IUSP usp1 = new USP();
            IUSP usp2 = new USP();

            Battery[] batteries1 = new Battery[25];
            for (int i = 0; i < 25; i++)
            {
                batteries1[i] = new Battery();
            }
            Battery[] batteries2 = new Battery[25];
            for (int i = 0; i < 25; i++)
            {
                batteries2[i] = new Battery();
            }

            usp1.setBatteries(batteries1);
            usp2.setBatteries(batteries2);

            ILargeHadronCollider lhc = new LargeHadronCollider.Builder()
                    .building(building)
                    .ring(ring)
                    .usp1(usp1)
                    .usp2(usp2)
                    .build();
            // <-- Change end

            this.largeHadronCollider = lhc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void lhcAssignments()
    {
        assertNotEquals(largeHadronCollider.getRing(), null);
        assertNotEquals(largeHadronCollider.getUSPs(), null);
        assertEquals(largeHadronCollider.getUSPs().length, 2);
        assertNotEquals(largeHadronCollider.getUSPs()[0], null);
        assertNotEquals(largeHadronCollider.getUSPs()[1], null);
    }

    @Test
    @Order(2)
    public void checkUSPBatteries()
    {
        assertEquals(largeHadronCollider.getUSPs()[0].getBatteries().length, 25);
        assertEquals(largeHadronCollider.getUSPs()[1].getBatteries().length, 25);

        for (int i = 0; i < 25; i++)
        {
            assertNotEquals(largeHadronCollider.getUSPs()[0].getBatteries()[i], null);
            assertNotEquals(largeHadronCollider.getUSPs()[1].getBatteries()[i], null);
        }
    }
}
