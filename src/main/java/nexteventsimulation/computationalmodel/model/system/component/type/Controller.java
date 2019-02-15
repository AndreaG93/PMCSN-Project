package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.component.Component;

public abstract class Controller extends Component {

    public Controller() {
        this.class1AverageArrivalRate = 4.0;
        this.class2AverageArrivalRate = 6.25;
    }

    @Override
    public void updateStatusAfterClass1JobArrival() {
    }

    @Override
    public void updateStatusAfterClass1JobDeparture() {
    }

    @Override
    public void updateStatusAfterClass2JobArrival() {
    }

    @Override
    public void updateStatusAfterClass2JobDeparture() {
    }
}
