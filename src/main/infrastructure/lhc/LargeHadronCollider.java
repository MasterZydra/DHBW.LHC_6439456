package main.infrastructure.lhc;

import main.infrastructure.energy.IUSP;
import main.infrastructure.lhc.IRing;

public class LargeHadronCollider implements ILargeHadronCollider {
    private IBuilding building;
    private IRing ring;
    private IUSP[] usps;

    public LargeHadronCollider() {
        this.usps = new IUSP[2];
    }

    public void setBuilding(IBuilding building) {
        this.building = building;
    }

    public void setRing(IRing ring) {
        this.ring = ring;
    }

    public void setUSPs(IUSP usp1, IUSP usp2) {
        this.usps[0] = usp1;
        this.usps[1] = usp2;
    }

    public IRing getRing()
    {
        return ring;
    }

    public IUSP[] getUSPs()
    {
        return usps;
    }
}
