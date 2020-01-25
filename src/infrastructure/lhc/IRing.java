package infrastructure.lhc;

public interface IRing {
    void activate();
    void activate(int initialEnergy);
    void activateMagneticField();
    void releaseProton();
    void increaseEnergy(int delta);
    void collide(Proton proton01, Proton proton02);
    int decreaseEnergy();
    void shutdown();
}
