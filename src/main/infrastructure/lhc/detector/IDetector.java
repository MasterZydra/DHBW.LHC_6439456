package main.infrastructure.lhc.detector;

import main.infrastructure.lhc.experiment.IExperiment;

public interface IDetector extends IRODetector {
    void addExperiment(IExperiment experiment);
}
