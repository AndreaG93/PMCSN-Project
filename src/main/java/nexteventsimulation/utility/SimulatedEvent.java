package nexteventsimulation.utility;

public abstract class SimulatedEvent implements Comparable<SimulatedEvent> {

    protected double time;

    public abstract void perform();

    public abstract void scheduleFollowingEvent();

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public int compareTo(SimulatedEvent o) {
        return Double.compare(this.time, o.time);
    }
}
