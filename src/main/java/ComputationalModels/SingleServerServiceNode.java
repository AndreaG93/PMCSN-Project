package ComputationalModels;


import NextEventSimulation.Event;
import NextEventSimulation.NextEventSimulationComputationalModel;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SingleServerServiceNode implements NextEventSimulationComputationalModel {

    private final double INITIAL_TIME = 0.0;
    private final double TERMINAL_TIME = 20000.0;

    private Rvgs randomVariatesGenerator;
    private int numberOfJobs;
    private int departedJobs;
    private SimulationClock simulationClock;

    private double timeAveragedNumberOfJobs = 0;
    private double timeAveragedServiceTime = 0;

    private Method methodUsedToProcessJobDepartureEvent;
    private Method methodUsedToProcessJobArrivalEvent;
    private Method methodUsedToScheduleNextEventAfterJobDepartureEvent;
    private Method methodUsedToScheduleNextEventAfterJobArrivalEvent;

    private PriorityQueue<Event> eventsCalendar;

    public SingleServerServiceNode() {
        randomVariatesGenerator = new Rvgs(new Rngs());
        randomVariatesGenerator.rngs.plantSeeds(0);

        eventsCalendar = new PriorityQueue<Event>();

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
    }

    public void initializeSimulationClock() {
        simulationClock = new SimulationClock();
        simulationClock.setCurrentTime(INITIAL_TIME);
    }

    public void ScheduleInitialEvent() {
        scheduleJobArrivalEvent(INITIAL_TIME + getExponentialInterArrivalTime());
    }

    public void advanceSimulationClockToNextScheduledEvent() {

        Event nextEvent = this.eventsCalendar.peek();

        if (nextEvent != null) {
            simulationClock.setCurrentTime(nextEvent.getScheduledTime());
        }
    }

    public void performNextScheduledEvent() {

        Event nextEvent = this.eventsCalendar.peek();

        if (nextEvent != null) {
            nextEvent.perform();
        }
    }

    public void scheduleNextEvent() {

        Event currentEvent = this.eventsCalendar.poll();

        if (currentEvent != null)
            currentEvent.scheduleNextRelatedEvent();
    }

    public void updateStatistics() {
        timeAveragedNumberOfJobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentTime()) * numberOfJobs;
        timeAveragedServiceTime += (simulationClock.getNextEventTime() - simulationClock.getCurrentTime());
    }

    public boolean isEndingConditionReached() {
        return this.eventsCalendar.isEmpty();
    }


    public void ProcessJobArrivalEvent() {
        numberOfJobs++;
    }

    public void ProcessJobDepartureEvent() {
        numberOfJobs--;
        departedJobs++;
    }

    public void scheduleNextEventAfterJobArrivalEvent() {

        double nextArrivalTime = this.simulationClock.getCurrentTime() + getExponentialInterArrivalTime();

        if (nextArrivalTime < TERMINAL_TIME) {
            if (numberOfJobs == 1)
                scheduleJobDepartureEvent();
            else {
                scheduleJobArrivalEvent(nextArrivalTime);
            }
        }
    }

    public void scheduleNextEventAfterJobDepartureEvent() {

        if (this.numberOfJobs > 0)
            scheduleJobDepartureEvent();

    }


    private void scheduleJobArrivalEvent(double nextArrivalTime) {
        Event nextDepartureEvent = new Event();

        nextDepartureEvent.setMethodToInvokeWhenEventOccurs(this.methodUsedToProcessJobArrivalEvent);
        nextDepartureEvent.setMethodToInvokeForNextEventScheduling(this.methodUsedToScheduleNextEventAfterJobArrivalEvent);
        nextDepartureEvent.setSystem(this);

        nextDepartureEvent.setScheduledTime(nextArrivalTime);

        this.eventsCalendar.add(nextDepartureEvent);
    }

    private void scheduleJobDepartureEvent() {
        Event nextDepartureEvent = new Event();

        nextDepartureEvent.setMethodToInvokeWhenEventOccurs(this.methodUsedToProcessJobDepartureEvent);
        nextDepartureEvent.setMethodToInvokeForNextEventScheduling(this.methodUsedToScheduleNextEventAfterJobDepartureEvent);
        nextDepartureEvent.setSystem(this);

        nextDepartureEvent.setScheduledTime(this.simulationClock.getCurrentTime() + getErlangDistributedServiceTime());

        this.eventsCalendar.add(nextDepartureEvent);
    }


    public Map<String, Double> getSimulationResults() {

        Map<String, Double> simulationResults = new HashMap<String, Double>();

        System.out.println(departedJobs);
        simulationResults.put("Job", Double.valueOf(departedJobs));
        simulationResults.put("Average service time", timeAveragedServiceTime / departedJobs);
        simulationResults.put("Average number of Job", timeAveragedNumberOfJobs / departedJobs);

        return simulationResults;
    }

    private double getExponentialInterArrivalTime() {

        randomVariatesGenerator.rngs.selectStream(0);
        return randomVariatesGenerator.exponential(2.0);
    }


    private double getErlangDistributedServiceTime() {

        randomVariatesGenerator.rngs.selectStream(1);
        return randomVariatesGenerator.erlang(5, 0.3);
    }
}
