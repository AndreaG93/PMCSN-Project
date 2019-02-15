package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.Event;

public class Class1JobDeparture extends Event {

    @Override
    public void perform() {
        this.component.updateStatusAfterClass1JobDeparture();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}