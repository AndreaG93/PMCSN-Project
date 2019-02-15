package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.SystemUsingRoutingAlgorithm1;
import nexteventsimulation.computationalmodel.model.system.component.Component;
import nexteventsimulation.utility.SimulatedEvent;

public abstract class Event extends SimulatedEvent {

    protected Component component;
    protected SystemUsingRoutingAlgorithm1 system;

    protected boolean acceptedOnCloud = false;

    public void setSystem(SystemUsingRoutingAlgorithm1 system) {
        this.system = system;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void setAcceptedOnCloud(boolean acceptedOnCloud) {
        this.acceptedOnCloud = acceptedOnCloud;
    }
}
