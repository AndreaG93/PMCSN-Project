package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;

public abstract class Controller extends SystemComponent {

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

    @Override
    public void scheduleInitialEvent() {

        SystemEvent firstEventClass1 = SystemEventFactory.buildClass1JobArrival();
        SystemEvent firstEventClass2 = SystemEventFactory.buildClass1JobArrival();

        this.system.scheduleEventOnController(firstEventClass1, this.getNextClass1JobInterArrivalTime());
        this.system.scheduleEventOnController(firstEventClass2, this.getNextClass2JobInterArrivalTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {

        SystemEvent followingEventOnAnotherComponent = SystemEventFactory.buildClass1JobArrival();
        SystemEvent followingEventOnController = SystemEventFactory.buildClass1JobArrival();

        this.system.scheduleEventOnController(followingEventOnController, this.getNextClass1JobInterArrivalTime());

        this.performRoutingAlgorithm(followingEventOnAnotherComponent);
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {

        SystemEvent followingEventOnAnotherComponent = SystemEventFactory.buildClass2JobArrival();
        SystemEvent followingEventOnController = SystemEventFactory.buildClass2JobArrival();

        this.system.scheduleEventOnController(followingEventOnController, this.getNextClass2JobInterArrivalTime());

        this.performRoutingAlgorithm(followingEventOnAnotherComponent);
    }

    protected abstract void performRoutingAlgorithm(SystemEvent event);
}
