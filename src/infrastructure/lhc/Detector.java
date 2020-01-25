package infrastructure.lhc;

import infrastructure.lhc.Ring;
import infrastructure.security.Reader;

import java.util.LinkedList;

public class Detector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private LinkedList<Experiment> experimentList;
    private Reader reader;

    private IRing ring;

    public Detector() {
        this.experimentList = new LinkedList<>();
    }
}
