package nexteventsimulation.utility;

public abstract class SimulationEvent implements Comparable<SimulationEvent> {

    private double startTime;

    public abstract void perform();

    public abstract void scheduleFollowingEvent();

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    @Override
    public int compareTo(SimulationEvent o) {
        return Double.compare(this.startTime, o.startTime);
    }
}
