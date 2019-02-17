package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobDeparture;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobDeparture;
import nexteventsimulation.computationalmodel.model.system.component.Component;

public class Cloudlet extends Component {

    public Cloudlet(System system) {
        super(system);

        this.class1AverageServiceRate = 0.25;
        this.class2AverageServiceRate = 0.22;
    }

    @Override
    public void updateStatusAfterClass1JobArrival() {
        this.numberOfClass1Jobs++;
    }

    @Override
    public void updateStatusAfterClass1JobDeparture() {
        this.numberOfClass1Jobs--;
        this.numberOfClass1DepartedJobs++;
    }

    @Override
    public void updateStatusAfterClass2JobArrival() {
        this.numberOfClass2Jobs++;
    }

    @Override
    public void updateStatusAfterClass2JobDeparture() {
        this.numberOfClass2Jobs--;
        this.numberOfClass2DepartedJobs++;
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {
        this.system.scheduleCloudletEvent(Class1JobDeparture.class, this.getNextClass1JobDepartureTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        this.system.scheduleCloudletEvent(Class2JobDeparture.class, this.getNextClass2JobDepartureTime());
    }

    @Override
    public void scheduleInitialEvent() {
    }

    @Override
    public void updateStatistics() {

    }
}
