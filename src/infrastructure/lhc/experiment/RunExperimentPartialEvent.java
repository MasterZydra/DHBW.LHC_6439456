package infrastructure.lhc.experiment;

public class RunExperimentPartialEvent {
    private int initialEnergy;
    private ExperimentScope scope;

    public RunExperimentPartialEvent(int initialEnergy, ExperimentScope scope) {
        if (initialEnergy != 25 && initialEnergy != 50 && initialEnergy != 100)
            this.initialEnergy = 25000;
        else
            this.initialEnergy = initialEnergy * 1000;
        this.scope = scope;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public ExperimentScope getExperimentScope() {
        return this.scope;
    }
}
