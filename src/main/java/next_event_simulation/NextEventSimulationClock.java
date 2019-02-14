package next_event_simulation;

public class NextEventSimulationClock {

    private double currentTime;
    private double nextEventTime;

    public double getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    public double getNextEventTime() {
        return nextEventTime;
    }

    public void setNextEventTime(double nextEventTime) {
        this.nextEventTime = nextEventTime;
    }
}
