package nexteventsimulation.computationalmodel.model.system.component.type.subtype;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobArrival;


public class ControllerUsingRoutingAlgorithm2 extends Controller {

    public ControllerUsingRoutingAlgorithm2(System system) {
        super(system);
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();
        double actualTime = this.system.getActualClockTime();

        if (n1 == this.system.getThreshold())
            this.system.scheduleCloudEvent(Class1JobArrival.class, actualTime);
        else if ((n1 + n2) < this.system.getThreshold()) {

        } else if (n2 > 0) {
            this.system.scheduleCloudletEvent(Class1JobArrival.class, actualTime);
        } else
            this.system.scheduleCloudletEvent(Class1JobArrival.class, actualTime);


        this.system.scheduleControllerEvent(Class1JobArrival.class, this.getNextClass1JobArrivalTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();
        double actualTime = this.system.getActualClockTime();

        if ((n1 + n2) >= this.system.getThreshold())
            this.system.scheduleCloudEvent(Class2JobArrival.class, actualTime);
        else
            this.system.scheduleCloudletEvent(Class2JobArrival.class, actualTime);

        this.system.scheduleControllerEvent(Class2JobArrival.class, this.getNextClass2JobArrivalTime());
    }
}
