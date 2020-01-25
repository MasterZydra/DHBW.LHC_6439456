package infrastructure.energy;

import infrastructure.LargeHadronCollider;

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

    public void charge(ThreePinPlug plug) {

    }

    public int takeOut() {
        return 0;
    }
}
