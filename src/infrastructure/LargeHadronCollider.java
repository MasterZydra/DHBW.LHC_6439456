package infrastructure;

import infrastructure.energy.USP;
import infrastructure.lhc.Ring;

public class LargeHadronCollider {
    private Building building;
    private Ring ring;
    private USP[] usps;

    public LargeHadronCollider() {
        this.usps = new USP[2];
    }
}
