package infrastructure.lhc.experiment;

import infrastructure.lhc.Block;

import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private IBlock[] blocks;

    public Experiment() {
        this.uuid = UUID.randomUUID();
        this.blocks = new Block[200000];
        for (int i = 0; i < 200000; i++) {
            this.blocks[i] = new Block();
        }

        this.dateTimeStamp = (new Date()).toString();
    }

    @Override
    public String toString() {
        String ret = this.uuid + " - " + this.dateTimeStamp + " - ";
        ret += this.isHiggsBosonFound ? "Higgs found" : "Higgs not found";
        return ret;
    }

    public IBlock getBlock(int index) {
        return this.blocks[index];
    }

    public void setHiggsBosonFound() {
        this.isHiggsBosonFound = true;
    }
}
