package infrastructure;

import infrastructure.lhc.*;
import infrastructure.lhc.experiment.ExperimentScope;

public interface IControlCenter {
    void addSubscriber(Subscriber subscriber);
    void startExperiment();
    void startExperiment(ExperimentScope scope);
}
