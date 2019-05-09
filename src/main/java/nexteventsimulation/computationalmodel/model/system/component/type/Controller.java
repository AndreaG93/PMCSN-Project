package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;

public abstract class Controller extends SystemComponent {

    public Controller(System system) {
        super(system);
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
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {
        this.performRoutingAlgorithm(SystemEventFactory.buildClass1JobArrival());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        this.performRoutingAlgorithm(SystemEventFactory.buildClass2JobArrival());
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobDeparture() {
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobDeparture() {
    }

    @Override
    public void scheduleFollowingEventAfterPreviouslyInterruptedClass2JobArrival() {
    }

    protected abstract void performRoutingAlgorithm(SystemEvent event);
}
