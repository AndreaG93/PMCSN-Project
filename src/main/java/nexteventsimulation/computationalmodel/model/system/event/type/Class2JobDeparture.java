package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class Class2JobDeparture extends SystemEvent {

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterClass2JobDeparture();
        this.systemComponent.logChanges();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}