package infrastructure.lhc;

import infrastructure.lhc.detector.IDetector;

public interface IRing {
    void activate();
    void activate(int initialEnergy);
    void activateMagneticField();
    void releaseProton();
    void increaseEnergy(int delta);
    void collide();
    int decreaseEnergy();
    void shutdown();
    void setProtonTraps(ProtonTrap protonTrap1, ProtonTrap protonTrap2);
    void setDetector(IDetector detector);
}
