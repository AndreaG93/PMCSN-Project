package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.component.Component;
import nexteventsimulation.utility.SimulatedEvent;

public abstract class Event extends SimulatedEvent {

    public final String ARRIVAL = "Arrival";
    public final String DEPARTURE = "Departure";
    public final int CLASS1 = 1;
    public final int CLASS2 = 2;

    protected Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}