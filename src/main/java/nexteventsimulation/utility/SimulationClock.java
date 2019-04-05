package nexteventsimulation.utility;

public class SimulationClock {

    private static SimulationClock instance = null;

    private double currentEventTime;
    private double nextEventTime;

    private SimulationClock(){
    }

    public static SimulationClock getInstance() {
        if (instance == null)
            instance = new SimulationClock();
        return instance;
    }

    public double getCurrentEventTime() {
        return currentEventTime;
    }

    public void setCurrentEventTime(double currentEventTime) {
        this.currentEventTime = currentEventTime;
    }

    public double getNextEventTime() {
        return nextEventTime;
    }

    public void setNextEventTime(double nextEventTime) {
        this.nextEventTime = nextEventTime;
    }
}
