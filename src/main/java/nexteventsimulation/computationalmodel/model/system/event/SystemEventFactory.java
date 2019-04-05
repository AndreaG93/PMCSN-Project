package nexteventsimulation.computationalmodel.model.system.event;

import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobArrival;
import nexteventsimulation.computationalmodel.model.system.event.type.Class1JobDeparture;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobArrival;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobDeparture;

public class SystemEventFactory {

    public static SystemEvent buildClass1JobArrival() {
        return new Class1JobArrival();
    }

    public static SystemEvent buildClass2JobArrival() {
        return new Class2JobArrival();
    }

    public static SystemEvent buildClass1JobDeparture() {
        return new Class1JobDeparture();
    }

    public static SystemEvent buildClass2JobDeparture() {
        return new Class2JobDeparture();
    }
}
