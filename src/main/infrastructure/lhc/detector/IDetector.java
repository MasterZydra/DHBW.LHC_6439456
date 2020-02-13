package main.infrastructure.lhc.detector;

import main.infrastructure.lhc.experiment.IExperiment;

import java.util.List;

public interface IDetector extends IRODetector {
    void addExperiment(IExperiment experiment);
    Object getPort();
    List<IExperiment> getExperimentList();
}
