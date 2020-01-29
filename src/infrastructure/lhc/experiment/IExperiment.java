package infrastructure.lhc.experiment;

public interface IExperiment {
    IBlock getBlock(int index);
    void setHiggsBosonFound();
}
