package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class PreviouslyInterruptedClass2JobDeparture extends SystemEvent {

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterPreviouslyInterruptedClass2JobDeparture();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.systemComponent.scheduleFollowingEventAfterClass2JobDeparture();
    }
}