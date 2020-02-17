package main.infrastructure.energy;

import main.infrastructure.lhc.LargeHadronCollider;

public class USP implements IUSP {
    private boolean isStandBy;
    private boolean isActivated;

    private Battery[] batteries;
    private LargeHadronCollider lhc;

    public USP() {
        this.batteries = new Battery[25];
    }

    public void determineChargeState() {

    }

    public void charge(IThreePinPlug plug) {

    }

    public int takeOut() {
        return 0;
    }

    public void setBatteries(Battery[] batteries) throws Exception {
        if (batteries.length != 25)
            throw new Exception("Invalid amount of batteries. 25 batteries expected");

        for (int i = 0; i < 25; i++)
            this.batteries[i] = batteries[i];
    }

    public Battery[] getBatteries() {
        return this.batteries;
    }
}
