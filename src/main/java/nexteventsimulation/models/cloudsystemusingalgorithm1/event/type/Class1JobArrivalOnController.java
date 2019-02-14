package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class1JobArrivalOnController extends Event {

    @Override
    public void perform() {
    }

    @Override
    public void scheduleFollowingEvent() {

        if (this.system.isFull())
            this.system.scheduleClass1JobArrivalEventOnCloudAt(this.time);
        else
            this.system.scheduleClass1JobArrivalEventOnCloudletAt(this.time);

        double nextClass1JobArrivalTime = this.system.computeNextClass1JobArrivalTime();

        if (nextClass1JobArrivalTime < this.system.getSimulationTerminationTime())
            this.system.scheduleClass1JobArrivalEventOnController(nextClass1JobArrivalTime);
    }
}