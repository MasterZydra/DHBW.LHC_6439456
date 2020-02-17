package main.infrastructure.lhc;

import main.infrastructure.energy.IUSP;

public class LargeHadronCollider implements ILargeHadronCollider {
    private IBuilding building;
    private IRing ring;
    private IUSP[] usps;

    private LargeHadronCollider(Builder builder) {
        this.building = builder.building;
        this.building.setLargeHadronCollider(this);

        this.ring = builder.ring;
        this.ring.setLargeHadronCollider(this);

        this.usps = builder.usps;
    }

    public IRing getRing()
    {
        return ring;
    }

    public IUSP[] getUSPs()
    {
        return usps;
    }

    public static class Builder {
        private IBuilding building;
        private IRing ring;
        private IUSP[] usps = new IUSP[2];

        public Builder building(IBuilding building) {
            this.building = building;
            return this;
        }

        public Builder ring(IRing ring) {
            this.ring = ring;
            return this;
        }

        public Builder usp1(IUSP usp) {
            this.usps[0] = usp;
            return this;
        }

        public Builder usp2(IUSP usp) {
            this.usps[1] = usp;
            return this;
        }

        public LargeHadronCollider build() {
            return new LargeHadronCollider(this);
        }
    }
}

