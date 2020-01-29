package infrastructure.lhc;

import infrastructure.lhc.experiment.IBlock;

import java.util.UUID;

public class Block implements IBlock {
    private UUID uuid;
    private String structure;

    public String getStructure() {
        return this.structure;
    }
}
