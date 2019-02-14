package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class2JobArrival extends Event {

    @Override
    public void perform() {
        this.component.incrementNumberOfClass2Jobs();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.component.scheduleClass2JobDeparture();
    }
}
