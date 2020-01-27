package infrastructure.lhc;

import infrastructure.security.IReader;

import java.util.LinkedList;
import java.util.List;

public class Detector implements IRODetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<Experiment> experimentList;
    private IReader reader;

    private IRing ring;

    public Detector() {
        this.experimentList = new LinkedList<>();
    }

    public void viewExperiments() {
        for(Experiment experiment : this.experimentList) {
            System.out.println(experiment);
        }
    }

    public void addExperiment(Experiment experiment) {
        this.experimentList.add(experiment);
    }
}
