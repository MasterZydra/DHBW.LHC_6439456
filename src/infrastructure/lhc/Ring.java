package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;
import infrastructure.LargeHadronCollider;
import infrastructure.lhc.detector.Detector;
import infrastructure.lhc.experiment.*;

public class Ring extends Subscriber implements IRing {
    private boolean isActivated;
    private Experiment currentExperiment;
    private int energy;

    private Magnet[] magnets;
    private ProtonTrap[] protonTrap;
    private Detector detector;
    private LargeHadronCollider lhc;

    public Ring() {
        super();
        this.protonTrap = new ProtonTrap[2];
        this.magnets = new Magnet[72];
        for (int i = 0; i < 72; i++) {
            this.magnets[i] = new Magnet();
        }
    }

    public void activate() {

    }

    public void activate(int initialEnergy) {

    }

    public void activateMagneticField() {

    }

    public void releaseProton() {

    }

    public void increaseEnergy(int delta) {

    }

    public void collide(Proton proton01, Proton proton02) {

    }

    public int decreaseEnergy() {
        return 0;
    }

    public void shutdown() {

    }

    @Subscribe
    public void receive(RunExperimentFullEvent event) {
        activate(event.getInitialEnergy());
        activateMagneticField();
        releaseProton();
        releaseProton();
        while(this.energy < 300000) {
            increaseEnergy(25000);
        }
        //collide();
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent event) {

    }
}
