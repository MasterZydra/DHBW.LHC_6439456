package main.infrastructure.lhc.experiment;

import java.util.List;

public interface IExperiment {
    IBlock getBlock(int index);
    void setHiggsBosonFound();
    void setProtonIDs(int protonId1, int protonId2);
    boolean getHiggsBosonFound();
    String getSQLString();
    String getID();
    void addBlock(IBlock block);
    List<IBlock> getBlocks();
}
