package main.infrastructure.lhc.experiment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Experiment implements IExperiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private int[] protonIDs;

    private List<IBlock> blocks;

    public Experiment() {
        this.uuid = UUID.randomUUID();
        this.protonIDs = new int[2];
        this.blocks = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            this.blocks.add(new Block());
        }

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.dateTimeStamp = (dateFormat.format(new Date()));
    }

    public Experiment(String uuid, String dateTimeStamp, boolean isHiggsBosonFound, int proton1, int proton2) {
        this.uuid = UUID.fromString(uuid);
        this.dateTimeStamp = dateTimeStamp;
        this.isHiggsBosonFound = isHiggsBosonFound;
        this.protonIDs = new int[2];
        this.blocks = new ArrayList<>();
        this.setProtonIDs(proton1, proton2);
    }

    @Override
    public String toString() {
        String ret = this.isHiggsBosonFound ? "Higgs found" : "NO Higgs found";
        ret += " -- ";
        ret += this.uuid + " - " + this.dateTimeStamp;
        ret += " - Protons: " + Integer.toString(this.protonIDs[0]);
        ret += ", " + Integer.toString(this.protonIDs[1]);
        return ret;
    }

    public IBlock getBlock(int index) {
        return this.blocks.get(index);
    }

    public void setHiggsBosonFound() {
        this.isHiggsBosonFound = true;
    }

    public void setProtonIDs(int protonId1, int protonId2) {
        this.protonIDs[0] = protonId1;
        this.protonIDs[1] = protonId2;
    }

    public boolean getHiggsBosonFound()
    {
        return this.isHiggsBosonFound;
    }

    public String getSQLString() {
        String ret = "'" + this.uuid.toString() + "', '" + this.dateTimeStamp + "', ";
        ret += this.isHiggsBosonFound;
        ret += ", ";
        ret += this.protonIDs[0] + ", " + this.protonIDs[1];
        return ret;
    }

    public String getID() {
        return this.uuid.toString();
    }

    public void addBlock(IBlock block) {
        this.blocks.add(block);
    }

    public List<IBlock> getBlocks() {
        return this.blocks;
    }
}
