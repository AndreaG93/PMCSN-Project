package nexteventsimulation.models.cloudsystemusingalgorithm1.component.type;

import nexteventsimulation.models.cloudsystemusingalgorithm1.component.Component;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.type.Class1JobDeparture;

public class Cloudlet extends Component {

    private final double CLASS_1_AVERAGE_SERVICE_RATE = 0.25;
    private final double CLASS_2_AVERAGE_SERVICE_RATE = 0.22;

    @Override
    public double computeNextClass1JobDepartureTime(){
        return this.simulationClock.getTime() + randomNumberGenerator.getExponentialServiceTime(CLASS_1_AVERAGE_SERVICE_RATE);
    }

    @Override
    public double computeNextClass2JobDepartureTime(){
        return this.simulationClock.getTime() + randomNumberGenerator.getExponentialServiceTime(CLASS_2_AVERAGE_SERVICE_RATE);
    }
}
