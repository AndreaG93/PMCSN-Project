package nexteventsimulation.computationalmodel.model.system.component.type.subtype;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;

import java.util.HashMap;
import java.util.Map;

public class ControllerUsingRoutingAlgorithm2 extends Controller {

    private double numberOfInterruptedClass2Jobs = 0;
    private double numberOfClass2JobsForwardedToCloudlet = 0;
    private double numberOfTotalClass2Jobs = 0;

    public ControllerUsingRoutingAlgorithm2(System system) {
        super(system);
    }

    @Override
    public Map<String, Double> getStatistics() {

        Map<String, Double> output = new HashMap<String, Double>();
        output.put("InterruptedClass2JobsNumber", this.numberOfInterruptedClass2Jobs);
        output.put("InterruptedClass2JobsNumberPercentage", this.numberOfInterruptedClass2Jobs / this.numberOfClass2JobsForwardedToCloudlet * 100.00);
        output.put("InterruptedClass2JobsNumberPercentageGlobal", this.numberOfInterruptedClass2Jobs / this.numberOfTotalClass2Jobs * 100.00);

        return output;
    }

    @Override
    protected void performRoutingAlgorithm(SystemEvent event) {

        int n1 = this.system.getNumberOfClass1JobOnCloudlet();
        int n2 = this.system.getNumberOfClass2JobOnCloudlet();

        if (event instanceof Class1JobArrival) {

            if (n1 == this.system.getThreshold())
                this.system.scheduleEventOnCloud(event, 0);
            else if (n1 + n2 < this.system.getThreshold())
                this.system.scheduleEventOnCloudlet(event, 0);
            else if (n2 > 0) {

                double runningCloudletTimeOfInterruptedJob = this.system.removeCloudletClass2JobDeparture();

                this.system.scheduleEventOnCloudlet(event, 0);

                double setupTime = RandomNumberGenerator.getInstance().getExponential(5, 0.8);

                this.system.scheduleEventOnCloud(SystemEventFactory.buildPreviouslyInterruptedClass2JobArrival(setupTime + runningCloudletTimeOfInterruptedJob), setupTime);

                this.numberOfInterruptedClass2Jobs++;

            } else
                this.system.scheduleEventOnCloudlet(event, 0);


        } else {

            this.numberOfTotalClass2Jobs++;

            if ((n1 + n2) >= this.system.getThreshold())
                this.system.scheduleEventOnCloud(event, 0);
            else {
                this.numberOfClass2JobsForwardedToCloudlet++;
                this.system.scheduleEventOnCloudlet(event, 0);
            }
        }
    }
}