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
    public void scheduleInitialEvent() {
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {
        this.system.scheduleEventOnCloud(SystemEventFactory.buildClass1JobDeparture(), this.getNextClass1JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        this.system.scheduleEventOnCloud(SystemEventFactory.buildClass2JobDeparture(), this.getNextClass2JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterPreviouslyInterruptedClass2JobArrival() {
        this.system.scheduleEventOnCloud(SystemEventFactory.buildPreviouslyInterruptedClass2JobDeparture(), this.getNextClass2JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobDeparture() {
        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass1JobDeparture());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobDeparture() {
        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass2JobDeparture());
    }
}