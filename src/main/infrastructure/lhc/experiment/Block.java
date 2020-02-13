package main.infrastructure.lhc.experiment;

import java.util.UUID;

public class Block implements IBlock {
    private UUID uuid;
    private String structure;

    public Block() {
        this.uuid = UUID.randomUUID();
    }

    public String getStructure() {
        return this.structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "'" + this.uuid.toString() + "', '" + this.structure + "'";
    }
}
