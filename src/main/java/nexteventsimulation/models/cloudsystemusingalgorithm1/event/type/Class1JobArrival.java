package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class1JobArrival extends Event {

    @Override
    public void perform() {
        this.component.incrementNumberOfClass1Jobs();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.component.scheduleClass1JobDeparture();
    }
}