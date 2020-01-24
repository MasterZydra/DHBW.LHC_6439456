package infrastructure;

import infrastructure.LargeHadronCollider;

public class Building {
    private String owner;
    private String location;

    private LargeHadronCollider largeHadronCollider;

    public Building() {
        this.owner = "CERN";
        this.location = "Geneva";
    }
}
