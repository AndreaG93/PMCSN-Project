package next_event_simulation;

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


    void perform() {
        try {
            this.methodToInvokeWhenEventOccurs.invoke(system);
        } catch (Exception p) {
            System.out.println(p.getMessage());
            System.exit(1);
        }
    }

    void scheduleNextRelatedEvent() {
        try {
            this.methodToInvokeForNextEventScheduling.invoke(system);
        } catch (Exception p) {
            System.exit(1);
        }
    }

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.scheduledTime, o.scheduledTime);
    }

/*
    @Override
    public int compareTo(Event o) {
        return Double.compare(this.getScheduledTime(), o.getScheduledTime());
    }
    */
}
