package NextEventSimulation;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class Event implements Comparable<Event> {

    private double scheduledTime;
    private Method methodToInvokeWhenEventOccurs;
    private Method methodToInvokeForNextEventScheduling;
    private Object system;

    public void setSystem(Object system) {
        this.system = system;
    }

    public void setMethodToInvokeWhenEventOccurs(Method methodToInvokeWhenEventOccurs) {
        this.methodToInvokeWhenEventOccurs = methodToInvokeWhenEventOccurs;
    }

    public void setMethodToInvokeForNextEventScheduling(Method methodToInvokeForNextEventScheduling) {
        this.methodToInvokeForNextEventScheduling = methodToInvokeForNextEventScheduling;
    }

    public double getScheduledTime() {
        return this.scheduledTime;
    }

    public void setScheduledTime(double scheduledTime) {
        this.scheduledTime = scheduledTime;
    }


    public void perform() {
        try {
            this.methodToInvokeWhenEventOccurs.invoke(system);
        } catch (Exception p) {
            System.exit(1);
        }
    }

    public void scheduleNextRelatedEvent() {
        try {
            this.methodToInvokeForNextEventScheduling.invoke(system);
        } catch (Exception p) {
            System.exit(1);
        }
    }


    public int compareTo(Event o) {

        if (this.getScheduledTime() < o.getScheduledTime())
            return -1;
        else if (this.getScheduledTime() == o.getScheduledTime()) {
            return 1;
        } else


            return 0;
    }
}
