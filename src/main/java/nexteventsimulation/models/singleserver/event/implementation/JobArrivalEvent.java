package nexteventsimulation.models.singleserver.event.implementation;

import nexteventsimulation.models.singleserver.event.SingleServerEvent;

public class JobArrivalEvent extends SingleServerEvent {

    @Override
    public void perform() {
        this.singleServer.incrementNumberOfJobs();
    }

    @Override
    public void scheduleFollowingEvent() {

        double nextJobArrivalTime = this.singleServer.computeNextJobArrivalTime();

        if (nextJobArrivalTime < this.singleServer.getSimulationTerminationTime())
            this.singleServer.scheduleJobArrivalEvent(nextJobArrivalTime);

        if (this.singleServer.getNumberOfJobs() == 1)
            this.singleServer.scheduleJobDepartureEvent();
    }
}
