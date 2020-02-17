package main.infrastructure.lhc;

public class Building implements IBuilding {
    private final String owner = "CERN";
    private final String location = "Geneva";

    private ILargeHadronCollider largeHadronCollider;

    public void setLargeHadronCollider(ILargeHadronCollider largeHadronCollider) {
        this.largeHadronCollider = largeHadronCollider;
    }
}
