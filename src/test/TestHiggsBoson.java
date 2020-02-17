package test;

import main.infrastructure.lhc.*;
import main.infrastructure.lhc.detector.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: 8093702
 */

public class TestHiggsBoson
{
    @Test
    @DisplayName("Check if detector finds the higgs boson")
    public void findHiggsBoson()
    {
        // Original code from author 8093702
        /*
        ProtonTrap protonTrap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap protonTrap2 = new ProtonTrap(ProtonTrapID.B);
         */

        // Fixed code after LHC training -> Use factory
        IProtonTrap protonTrap1 = ProtonTrapFactory.buildProtonTrapA();
        IProtonTrap protonTrap2 = ProtonTrapFactory.buildProtonTrapB();
        // <-- Change end

        Detector detector = new Detector();

        Ring ring = new Ring();
        ring.setProtonTraps(protonTrap1, protonTrap2);
        ring.setDetector(detector);

        ControlCenter controlCenter = ControlCenter.instance;

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(50);

        assertTrue(detector.getExperimentList().get(16).getHiggsBosonFound());
    }
}
