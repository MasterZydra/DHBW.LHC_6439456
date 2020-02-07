package main.infrastructure;

import main.infrastructure.lhc.*;
import main.infrastructure.lhc.experiment.ExperimentScope;

public interface IControlCenter {
    void addSubscriber(Subscriber subscriber);
    void startExperiment();
    void startExperiment(ExperimentScope scope);
}
