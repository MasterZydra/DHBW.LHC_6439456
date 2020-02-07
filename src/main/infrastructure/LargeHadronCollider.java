package main.infrastructure;

import main.infrastructure.energy.USP;
import main.infrastructure.lhc.IRing;

public class LargeHadronCollider {
    private Building building;
    private IRing ring;
    private USP[] usps;

    public LargeHadronCollider() {
        this.usps = new USP[2];
    }
}
