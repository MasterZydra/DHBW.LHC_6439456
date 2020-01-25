package infrastructure.energy;

public interface IUSP {
    void determineChargeState();
    void charge(ThreePinPlug plug);
    int takeOut();
}
