package nexteventsimulation.models.singleserver.event.type;

import nexteventsimulation.models.singleserver.event.SingleServerEvent;

public class JobDepartureEvent extends SingleServerEvent {

    @Override
    public void perform() {
        this.singleServer.decrementNumberOfJobs();
        this.singleServer.incrementNumberOfDepartedJob();
    }

    @Override
    public void scheduleFollowingEvent() {

        if (!this.singleServer.isEmpty())
            this.singleServer.scheduleJobDepartureEvent();
    }
}