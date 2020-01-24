package infrastructure.energy;

public class USP {
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
