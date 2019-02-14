package nexteventsimulation.models.cloudsystemusingalgorithm1.event;

import nexteventsimulation.models.cloudsystemusingalgorithm1.SystemUsingAlgorithm1;
import nexteventsimulation.models.cloudsystemusingalgorithm1.component.Component;
import nexteventsimulation.utility.SimulatedEvent;

public abstract class Event extends SimulatedEvent {


    protected Component component;
    protected SystemUsingAlgorithm1 system;

    protected boolean acceptedOnCloud = false;

    public void setSystem(SystemUsingAlgorithm1 system) {
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
