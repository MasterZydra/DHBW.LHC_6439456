package infrastructure.lhc;

public class ProtonTrap implements IProtonTrap {
    private ProtonTrapID id;

    private Proton[] protons;
    private IRing ring;

    public ProtonTrap() {
        this.protons = new Proton[100];
    }

    public void loadData(String dataFilePath) {

    }

    public void release() {

    }
}
