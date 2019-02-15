package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.Event;

public class Class1JobArrival extends Event {

    @Override
    public void perform() {
       this.component.updateStatusAfterClass1JobArrival();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.component.scheduleFollowingEventAfterClass1JobArrival();
    }
}