package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class Class2JobArrival extends SystemEvent {

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterClass2JobArrival();
        this.systemComponent.logChanges();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.systemComponent.scheduleFollowingEventAfterClass2JobArrival();
    }
}
