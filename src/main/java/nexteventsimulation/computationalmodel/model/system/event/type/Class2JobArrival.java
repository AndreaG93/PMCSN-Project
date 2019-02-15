package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.Event;

public class Class2JobArrival extends Event {

    @Override
    public void perform() {
        this.component.updateStatusAfterClass2JobArrival();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.component.scheduleFollowingEventAfterClass2JobArrival();
    }
}
