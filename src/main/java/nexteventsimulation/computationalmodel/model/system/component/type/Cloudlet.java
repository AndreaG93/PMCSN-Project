package nexteventsimulation.computationalmodel.model.system.component.type;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;

public class Cloudlet extends SystemComponent {

    public Cloudlet(System system) {
        super(system);

        this.class1AverageServiceRate = 0.45;
        this.class2AverageServiceRate = 0.27;
    }

    @Override
    public void scheduleInitialEvent() {
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobArrival() {
        SystemEvent event = SystemEventFactory.buildClass1JobDeparture();
        this.system.scheduleEventOnCloudlet(event, this.getNextClass1JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobArrival() {
        SystemEvent event = SystemEventFactory.buildClass2JobDeparture();
        this.system.scheduleEventOnCloudlet(event, this.getNextClass2JobServiceTime());
    }

    @Override
    public void scheduleFollowingEventAfterClass1JobDeparture() {
        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass1JobDeparture());
    }

    @Override
    public void scheduleFollowingEventAfterClass2JobDeparture() {
        this.system.scheduleEventOnGlobalNetwork(SystemEventFactory.buildClass2JobDeparture());
    }

    @Override
    public void scheduleFollowingEventAfterPreviouslyInterruptedClass2JobArrival() {
    }
}
