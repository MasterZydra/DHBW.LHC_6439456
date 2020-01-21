public class Ring {
    private boolean isActivated;
    private Experiment currentExperiment;
    private int energy;

    private Magnet[] magnets;
    private ProtonTrap protonTrap;
    private Detector detector;

    public Ring() {
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
}
