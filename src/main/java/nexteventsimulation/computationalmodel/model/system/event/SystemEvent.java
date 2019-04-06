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

    @Override
    public String toString() {
        return  String.format("EventType: %s, StartEventTime: %s, SystemComponentName: %s",
                this.getClass().getSimpleName(),
                String.valueOf(this.getStartTime()),
                this.systemComponent.getClass().getSimpleName()
                );
    }
}