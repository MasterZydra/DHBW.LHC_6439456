package main.infrastructure.lhc.experiment;

public interface IExperiment {
    IBlock getBlock(int index);
    void setHiggsBosonFound();
    void setProtonIDs(int protonId1, int protonId2);
    boolean getHiggsBosonFound();
    String getSQLString();
    String getID();
}
