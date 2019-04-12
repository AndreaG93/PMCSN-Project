package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;

public class GlobalNetwork extends SystemComponent {

    public GlobalNetwork(System system) {
        super(system);

        this.class1AverageArrivalRate = 4.0;
        this.class2AverageArrivalRate = 6.25;
    }

    @Override
    public void scheduleInitialEvent() {
        SystemEvent firstEventClass1 = SystemEventFactory.buildClass1JobArrival();
        SystemEvent firstEventClass2 = SystemEventFactory.buildClass2JobArrival();

        this.system.scheduleEventOnGlobalNetwork(firstEventClass1, this.getNextClass1JobInterArrivalTime());
        this.system.scheduleEventOnGlobalNetwork(firstEventClass2, this.getNextClass2JobInterArrivalTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {

        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass1JobArrival(), this.getNextClass1JobInterArrivalTime());
        this.system.scheduleEventOnController(SystemEventFactory.buildClass1JobArrival(), 0);
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass2JobArrival(), this.getNextClass2JobInterArrivalTime());
        this.system.scheduleEventOnController(SystemEventFactory.buildClass2JobArrival(), 0);
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobDeparture() {
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobDeparture() {
    }
}
