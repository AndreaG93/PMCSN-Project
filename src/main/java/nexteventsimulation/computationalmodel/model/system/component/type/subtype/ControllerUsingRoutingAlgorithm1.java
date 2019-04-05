package nexteventsimulation.computationalmodel.model.system.component.type.subtype;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;

public class ControllerUsingRoutingAlgorithm1 extends Controller {

    public ControllerUsingRoutingAlgorithm1(System system) {
        super(system);
    }

    @Override
    protected void performRoutingAlgorithm(SystemEvent event) {

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();

        if ((n1 + n2) == this.system.getThreshold())
            this.system.scheduleEventOnCloud(event, 0);
        else
            this.system.scheduleEventOnCloudlet(event, 0);
    }
}