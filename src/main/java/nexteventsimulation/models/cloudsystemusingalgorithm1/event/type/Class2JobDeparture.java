package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class2JobDeparture extends Event {

    @Override
    public void perform() {
        component.incrementNumberOfClass2DepartedJobsJobs();
        component.decrementNumberOfClass2Jobs();
    }

    @Override
    public void scheduleFollowingEvent() {
    }
}