package infrastructure.lhc;

public interface IProtonTrap {
    void loadData(int id, String dataFilePath);
    IProton release();
}
