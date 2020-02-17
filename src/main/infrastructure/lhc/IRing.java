package main.infrastructure.lhc;

import main.infrastructure.lhc.detector.IDetector;

public interface IRing {
    void activate();
    void activate(int initialEnergy);
    void activateMagneticField();
    void releaseProton();
    void increaseEnergy(int delta);
    void collide();
    int decreaseEnergy();
    void shutdown();
    void setProtonTraps(IProtonTrap protonTrap1, IProtonTrap protonTrap2);
    void setDetector(IDetector detector);
    void setLargeHadronCollider(ILargeHadronCollider largeHadronCollider);
}
