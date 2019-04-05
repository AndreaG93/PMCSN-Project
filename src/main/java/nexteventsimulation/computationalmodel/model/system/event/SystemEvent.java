package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.utility.SimulationEvent;

public abstract class SystemEvent extends SimulationEvent {

    protected SystemComponent systemComponent;

    public void setSystemComponent(SystemComponent systemComponent) {
        this.systemComponent = systemComponent;
    }

    public SystemComponent getSystemComponent() {
        return systemComponent;
    }
}