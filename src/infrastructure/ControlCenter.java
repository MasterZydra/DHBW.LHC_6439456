package infrastructure;

import com.google.common.eventbus.EventBus;
import infrastructure.lhc.AnalyseEvent;
import infrastructure.lhc.experiment.ExperimentScope;
import infrastructure.lhc.Subscriber;
import infrastructure.lhc.experiment.RunExperimentFullEvent;
import infrastructure.lhc.experiment.RunExperimentPartialEvent;

public enum ControlCenter implements IControlCenter {
    instance;

    private final String roomID;

    private EventBus eventBus;

    private Workplace workplace;

    ControlCenter() {
        this.roomID = "C01";
        this.eventBus = new EventBus(this.roomID);
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
}
