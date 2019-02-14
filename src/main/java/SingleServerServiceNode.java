import next_event_simulation.Event;
import next_event_simulation.NextEventSimulationComputationalModel;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SingleServerServiceNode extends NextEventSimulationComputationalModel {

    private final double INITIAL_TIME = 0.0;
    private final double TERMINAL_TIME = 20000.0;

    private int numberOfJobs;
    private int departedJobs;

    private double timeAveragedNumberOfJobs = 0;
    private double timeAveragedServiceTime = 0;

    private Method methodUsedToProcessJobDepartureEvent;
    private Method methodUsedToProcessJobArrivalEvent;
    private Method methodUsedToScheduleNextEventAfterJobDepartureEvent;
    private Method methodUsedToScheduleNextEventAfterJobArrivalEvent;

    public SingleServerServiceNode() {

        try {
            methodUsedToProcessJobDepartureEvent = this.getClass().getDeclaredMethod("ProcessJobDepartureEvent");
            methodUsedToProcessJobArrivalEvent = this.getClass().getDeclaredMethod("ProcessJobArrivalEvent");
            methodUsedToScheduleNextEventAfterJobDepartureEvent = this.getClass().getDeclaredMethod("scheduleNextEventAfterJobDepartureEvent");
            methodUsedToScheduleNextEventAfterJobArrivalEvent = this.getClass().getDeclaredMethod("scheduleNextEventAfterJobArrivalEvent");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void initializeSystemStateVariables() {
        numberOfJobs = 0;
        departedJobs = 0;
    }

    public void initializeSimulationClock() {
        nextEventSimulationClock.setCurrentTime(INITIAL_TIME);
    }

    public void ScheduleInitialEvent() {
        scheduleJobArrivalEvent(INITIAL_TIME + randomVariatesGenerator.getExponentialInterArrivalTime());
    }


    public void updateStatistics() {
        timeAveragedNumberOfJobs += (nextEventSimulationClock.getNextEventTime() - nextEventSimulationClock.getCurrentTime()) * numberOfJobs;
        timeAveragedServiceTime += (nextEventSimulationClock.getNextEventTime() - nextEventSimulationClock.getCurrentTime());

        if (nextEventSimulationClock.getNextEventTime() - nextEventSimulationClock.getCurrentTime() == 0){
            System.exit(33);
        }
    }

    public void ProcessJobArrivalEvent() {
        numberOfJobs++;
    }

    public void ProcessJobDepartureEvent() {
        numberOfJobs--;
        departedJobs++;
    }

    public void scheduleNextEventAfterJobArrivalEvent() {

        double nextArrivalTime = this.nextEventSimulationClock.getCurrentTime() + randomVariatesGenerator.getExponentialInterArrivalTime();

        if (nextArrivalTime < TERMINAL_TIME) {
            scheduleJobArrivalEvent(nextArrivalTime);
        }

        if (numberOfJobs == 1)
            scheduleJobDepartureEvent();
    }

    public void scheduleNextEventAfterJobDepartureEvent() {

        if (this.numberOfJobs > 0)
            scheduleJobDepartureEvent();

    }


    public void scheduleJobArrivalEvent(double nextArrivalTime) {

        Event nextDepartureEvent = new Event();

        nextDepartureEvent.setMethodToInvokeWhenEventOccurs(this.methodUsedToProcessJobArrivalEvent);
        nextDepartureEvent.setMethodToInvokeForNextEventScheduling(this.methodUsedToScheduleNextEventAfterJobArrivalEvent);
        nextDepartureEvent.setSystem(this);

        nextDepartureEvent.setScheduledTime(nextArrivalTime);

        this.eventList.add(nextDepartureEvent);
    }

    public void scheduleJobDepartureEvent() {
        Event nextDepartureEvent = new Event();

        nextDepartureEvent.setMethodToInvokeWhenEventOccurs(this.methodUsedToProcessJobDepartureEvent);
        nextDepartureEvent.setMethodToInvokeForNextEventScheduling(this.methodUsedToScheduleNextEventAfterJobDepartureEvent);
        nextDepartureEvent.setSystem(this);

        nextDepartureEvent.setScheduledTime(this.nextEventSimulationClock.getCurrentTime() + randomVariatesGenerator.getErlangDistributedServiceTime());

        this.eventList.add(nextDepartureEvent);
    }


    public Map<String, Double> getSimulationResults() {

        Map<String, Double> simulationResults = new HashMap<String, Double>();

        System.out.println(departedJobs);
        simulationResults.put("Job", Double.valueOf(departedJobs));
        simulationResults.put("Average service time", timeAveragedServiceTime / departedJobs);
        simulationResults.put("Average number of Job", timeAveragedNumberOfJobs / nextEventSimulationClock.getCurrentTime());
        simulationResults.put("Average wait", timeAveragedNumberOfJobs / departedJobs);
        simulationResults.put("utili", timeAveragedServiceTime / nextEventSimulationClock.getCurrentTime());

        return simulationResults;
    }


}
