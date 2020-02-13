package main.infrastructure;

import main.infrastructure.lhc.*;
import main.infrastructure.lhc.experiment.ExperimentScope;

public interface IControlCenter {
    void addSubscriber(Subscriber subscriber);
    void startExperiment(int initialEnergy);
    void startExperiment(int initialEnergy, ExperimentScope scope);
    void setWorkplaces(IWorkplace[] workplaces);
    IWorkplace[] getWorkplaces();
}
