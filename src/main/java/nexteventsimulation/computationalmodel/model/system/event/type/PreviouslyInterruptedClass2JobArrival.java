package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class PreviouslyInterruptedClass2JobArrival extends SystemEvent {

    private double delay;

    public PreviouslyInterruptedClass2JobArrival(double delay) {
        this.delay = delay;
    }

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterPreviouslyInterruptedClass2JobArrival(this.delay);
    }

    @Override
    public void scheduleFollowingEvent() {
        this.systemComponent.scheduleFollowingEventAfterPreviouslyInterruptedClass2JobArrival();
    }
}
