package nexteventsimulation.computationalmodel.model.system.event.type;

import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class Class2JobDeparture extends SystemEvent {

    private double jobExecutionStartTime;

    public Class2JobDeparture(double jobExecutionStartTime) {
        this.jobExecutionStartTime = jobExecutionStartTime;
    }

    @Override
    public void perform() {
        this.systemComponent.updateStatusAfterClass2JobDeparture();
    }

    @Override
    public void scheduleFollowingEvent() {
        this.systemComponent.scheduleFollowingEventAfterClass2JobDeparture();
    }

    public double getJobExecutionStartTime() {
        return jobExecutionStartTime;
    }
}