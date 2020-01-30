package infrastructure.lhc;

public class Proton implements IProton {
    private int id;
    private int[][][] structure;
    private double weight;

    public Proton(int id, int[][][] structure) {
        this.structure = structure;
        this.id = id;
    }

    public int[][][] getStructure() {
        return this.structure;
    }

    public int getID() {
        return this.id;
    }
}
