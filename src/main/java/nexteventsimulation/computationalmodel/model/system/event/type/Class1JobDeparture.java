package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class Class1JobDeparture extends SystemEvent {

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterClass1JobDeparture();
        this.systemComponent.logChanges();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}