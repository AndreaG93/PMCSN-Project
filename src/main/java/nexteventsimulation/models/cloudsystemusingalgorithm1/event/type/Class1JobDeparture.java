package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class1JobDeparture extends Event {

    @Override
    public void perform() {
        component.incrementNumberOfClass1DepartedJobsJobs();
        component.decrementNumberOfClass1Jobs();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}