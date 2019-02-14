package nexteventsimulation.models.cloudsystemusingalgorithm1.event.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;

public class Class2JobArrivalOnController extends Event {

    @Override
    public void perform() {
    }

    @Override
    public void scheduleFollowingEvent() {

        if (this.system.isFull())
            this.system.scheduleClass2JobArrivalEventOnCloudAt(this.time);
        else
            this.system.scheduleClass2JobArrivalEventOnCloudletAt(this.time);

        double nextClass2JobArrivalTime = this.system.computeNextClass1JobArrivalTime();

        if (nextClass2JobArrivalTime < this.system.getSimulationTerminationTime())
            this.system.scheduleClass2JobArrivalEventOnController(nextClass2JobArrivalTime);
    }
}