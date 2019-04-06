package nexteventsimulation.computationalmodel.model.system.component.type.subtype;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.utility.RandomNumberGenerator;

public class ControllerUsingRoutingAlgorithm2 extends Controller {

    public ControllerUsingRoutingAlgorithm2(System system) {
        super(system);
    }

    @Override
    protected void performRoutingAlgorithm(SystemEvent event) {

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();

        if (event instanceof Class1JobArrival) {

            if (n1 == this.system.getThreshold())
                this.system.scheduleEventOnCloud(event, 0);
            else if (n1 + n2 < this.system.getThreshold())
                if (n2 > 0) {

                    this.system.removeFarthermostCloudletClass2JobDeparture();

                    this.system.scheduleEventOnCloudlet(event, 0);

                    double setupTime = RandomNumberGenerator.getInstance().getExponential(5, 0.8);

                    this.system.scheduleEventOnCloud(SystemEventFactory.buildClass2JobArrival(), setupTime);

                } else
                    this.system.scheduleEventOnCloudlet(event, 0);

        } else {

            if ((n1 + n2) >= this.system.getThreshold())
                this.system.scheduleEventOnCloud(event, 0);
            else
                this.system.scheduleEventOnCloudlet(event, 0);
        }
    }
}
