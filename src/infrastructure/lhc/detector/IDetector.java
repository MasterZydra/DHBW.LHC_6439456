package infrastructure.lhc.detector;

import infrastructure.lhc.experiment.IExperiment;

public interface IDetector extends IRODetector {
    void addExperiment(IExperiment experiment);
}
