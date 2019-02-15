package nexteventsimulation.computationalmodel.model.system.component.type.subtype;

import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobArrival;

public class ControllerUsingRoutingAlgorithm1 extends Controller {

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {
        performRoutingAlgorithmOne(Class1JobArrival.class);
        this.system.scheduleControllerEvent(Class1JobArrival.class, this.getNextClass1JobArrivalTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        performRoutingAlgorithmOne(Class2JobArrival.class);
        this.system.scheduleControllerEvent(Class2JobArrival.class, this.getNextClass2JobArrivalTime());
    }

    private void performRoutingAlgorithmOne(Class eventClass){

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();
        double actualTime = this.system.getActualClockTime();

        if ((n1 + n2) == this.system.getThreshold())
            this.system.scheduleCloudEvent(eventClass, actualTime);
        else
            this.system.scheduleCloudletEvent(eventClass, actualTime);
    }
}