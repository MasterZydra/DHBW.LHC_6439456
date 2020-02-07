package main.infrastructure;

import com.google.common.eventbus.EventBus;
import main.infrastructure.lhc.AnalyseEvent;
import main.infrastructure.lhc.Subscriber;
import main.infrastructure.lhc.experiment.*;

public enum ControlCenter implements IControlCenter {
    instance;

    private final String roomID;

    private EventBus eventBus;

    private IWorkplace[] workplaces;

    ControlCenter() {
        this.roomID = "C01";
        this.eventBus = new EventBus(this.roomID);
        workplaces = new IWorkplace[3];
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void startExperiment() {
        eventBus.post(new RunExperimentFullEvent(50));
        eventBus.post(new AnalyseEvent());
    }

    public void startExperiment(ExperimentScope scope) {
        eventBus.post(new RunExperimentPartialEvent(50, scope));
        eventBus.post(new AnalyseEvent());
    }

    public IWorkplace[] getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(IWorkplace[] workplaces) {
        this.workplaces = workplaces;
    }
}