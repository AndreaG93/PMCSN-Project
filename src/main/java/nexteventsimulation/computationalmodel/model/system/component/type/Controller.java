package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.Component;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobArrival;

public abstract class Controller extends Component {

    public Controller(System system) {
        super(system);

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

    @Override
    public void updateStatistics() {
    }


    public void scheduleInitialEvent() {
        this.system.scheduleControllerEvent(Class1JobArrival.class, this.getNextClass2JobArrivalTime());
        this.system.scheduleControllerEvent(Class2JobArrival.class, this.getNextClass2JobArrivalTime());
    }
}
