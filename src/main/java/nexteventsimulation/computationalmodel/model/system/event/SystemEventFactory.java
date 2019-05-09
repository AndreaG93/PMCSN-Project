package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.event.type.*;
import nexteventsimulation.utility.SimulationClock;

public class SystemEventFactory {

    public static SystemEvent buildClass1JobArrival() {
        return new Class1JobArrival();
    }

    public static SystemEvent buildClass2JobArrival() {
        return new Class2JobArrival();
    }

    public static SystemEvent buildPreviouslyInterruptedClass2JobArrival(double delay) {
        return new PreviouslyInterruptedClass2JobArrival(delay);
    }

    public static SystemEvent buildClass1JobDeparture() {
        return new Class1JobDeparture();
    }

    public static SystemEvent buildClass2JobDeparture() {
        return new Class2JobDeparture(SimulationClock.getInstance().getCurrentEventTime());
    }

    public static SystemEvent buildPreviouslyInterruptedClass2JobDeparture() {
        return new PreviouslyInterruptedClass2JobDeparture();
    }
}
