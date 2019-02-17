package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.component.Component;
import nexteventsimulation.utility.SimulatedEvent;

public abstract class Event extends SimulatedEvent {

    protected Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}