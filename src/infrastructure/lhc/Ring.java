package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;
import infrastructure.LargeHadronCollider;
import infrastructure.lhc.detector.*;
import infrastructure.lhc.experiment.*;

public class Ring extends Subscriber implements IRing {
    private boolean isActivated;
    private Experiment currentExperiment;
    private int energy;

    private IMagnet[] magnets;
    private ProtonTrap[] protonTraps;
    private IDetector detector;
    private LargeHadronCollider lhc;

    private IProton proton1;
    private IProton proton2;

    public Ring() {
        super();
        this.protonTraps = new ProtonTrap[2];
        this.magnets = new Magnet[72];
        for (int i = 0; i < 72; i++) {
            this.magnets[i] = new Magnet();
        }
    }

    public void setDetector(IDetector detector) {
        this.detector = detector;
    }

    public void setProtonTraps(ProtonTrap protonTrap1, ProtonTrap protonTrap2) {
        this.protonTraps[0] = protonTrap1;
        this.protonTraps[1] = protonTrap2;
    }

    public void activate() {
        this.activate(25000);
    }

    public void activate(int initialEnergy) {
        this.energy = initialEnergy;
        this.isActivated = true;
        this.currentExperiment = new Experiment();
    }

    public void activateMagneticField() {
        for (int i = 0; i < this.magnets.length; i++) {
            this.magnets[i].activate();
        }
    }

    public void releaseProton() {
        this.proton1 = this.protonTraps[0].release();
        this.proton2 = this.protonTraps[1].release();
    }

    public void increaseEnergy(int delta) {
        this.energy += delta;
    }

    private String structureToString(int[][][] structure) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                for (int k = 0; k < structure[i][j].length; k++) {
                    ret.append((char) structure[i][j][k]);
                }
            }
        }
        return ret.toString();
    }

    public void collide() {
        String proton1Cont = structureToString(this.proton1.getStructure());
        String proton2Cont = structureToString(this.proton2.getStructure());

        currentExperiment.setProtonIDs(this.proton1.getID(), this.proton2.getID());
        for (int i = 0; i < 200000; i++) {
            currentExperiment.getBlock(i).setStructure(proton1Cont.substring(i * 5, i * 5 + 5) + proton2Cont.substring(i * 5, i * 5 + 5));
        }
        this.proton1 = null;
        this.proton2 = null;
    }

    public int decreaseEnergy() {
        this.energy = 0;
        return this.energy;
    }

    public void shutdown() {
        this.detector.addExperiment(this.currentExperiment);
        this.currentExperiment = null;

        this.decreaseEnergy();
        for (int i = 0; i < this.magnets.length; i++) {
            this.magnets[i].deactivated();
        }
        this.isActivated = false;
    }

    private void executeExperiment(int initialEnergy) {
        this.activate(initialEnergy);
        this.activateMagneticField();
        this.releaseProton();
        while(this.energy < 300000) {
            increaseEnergy(25000);
        }
        this.collide();
        this.shutdown();
    }

    @Subscribe
    public void receive(RunExperimentFullEvent event) {
        for (int i = 0; i < 25; i++)
            this.executeExperiment(event.getInitialEnergy());
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent event) {
        int circulationNr = 0;
        switch (event.getExperimentScope()) {
            case ES5:       circulationNr = 5; break;
            case ES10:      circulationNr = 10; break;
            case ES20:      circulationNr = 20; break;
            case ESFull:    circulationNr = 25; break;
        }

        for (int i = 0; i < circulationNr; i++)
            this.executeExperiment(event.getInitialEnergy());
    }
}
