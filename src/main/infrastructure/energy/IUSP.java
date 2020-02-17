package main.infrastructure.energy;

public interface IUSP {
    void determineChargeState();
    void charge(IThreePinPlug plug);
    int takeOut();
    void setBatteries(Battery[] batteries) throws Exception;
    Battery[] getBatteries();
}
