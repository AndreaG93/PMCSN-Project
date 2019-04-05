package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;


public class Cloud extends SystemComponent {

    public Cloud(System system){
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
    public void scheduleInitialEvent() {
    }

    @Override
    public void updateStatistics(){
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {

        SystemEvent event = SystemEventFactory.buildClass1JobDeparture();
        this.system.scheduleEventOnCloud(event, this.getNextClass1JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {

        SystemEvent event = SystemEventFactory.buildClass2JobDeparture();
        this.system.scheduleEventOnCloud(event, this.getNextClass2JobServiceTime());
    }
}