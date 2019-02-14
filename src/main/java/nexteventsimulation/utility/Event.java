package nexteventsimulation.utility;

public abstract class Event implements Comparable<Event> {

    private double time;

    public abstract void perform();

    public abstract void scheduleFollowingEvent();

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.time, o.time);
    }
}
