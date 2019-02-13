package ComputationalModels;

public class SimulationClock {

    private double previousEventTime;
    private double nextEventTime;
    private double lastEventTime;
    private double currentTime;

    public double getPreviousEventTime() {
        return previousEventTime;
    }

    public void setPreviousEventTime(double previousEventTime) {
        this.previousEventTime = previousEventTime;
    }

    public double getNextEventTime() {
        return nextEventTime;
    }

    public void setNextEventTime(double nextEventTime) {
        this.nextEventTime = nextEventTime;
    }

    public double getLastEventTime() {
        return lastEventTime;
    }

    public void setLastEventTime(double lastEventTime) {
        this.lastEventTime = lastEventTime;
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }
}
