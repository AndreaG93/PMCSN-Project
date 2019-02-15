package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.Event;

public class Class2JobDeparture extends Event {

    @Override
    public void perform() {
        this.component.updateStatusAfterClass2JobDeparture();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}