package infrastructure;

import infrastructure.energy.USP;
import infrastructure.lhc.IRing;

public class LargeHadronCollider {
    private Building building;
    private IRing ring;
    private USP[] usps;

    public LargeHadronCollider() {
        this.usps = new USP[2];
    }
}
