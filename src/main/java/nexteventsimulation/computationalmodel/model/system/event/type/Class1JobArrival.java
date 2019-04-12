package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class Class1JobArrival extends SystemEvent {

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterClass1JobArrival();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.systemComponent.scheduleFollowingEventAfterClass1JobArrival();
    }
}