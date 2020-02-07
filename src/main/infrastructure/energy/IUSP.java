package main.infrastructure.energy;

public interface IUSP {
    void determineChargeState();
    void charge(ThreePinPlug plug);
    int takeOut();
    void setBatteries(Battery[] batteries) throws Exception;
}
