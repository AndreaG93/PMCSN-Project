package nexteventsimulation.models.singleserver;

import nexteventsimulation.models.ComputationalModel;
import nexteventsimulation.models.singleserver.event.SingleServerEvent;
import nexteventsimulation.models.singleserver.event.implementation.JobArrivalEvent;
import nexteventsimulation.models.singleserver.event.implementation.JobDepartureEvent;

import java.util.HashMap;
import java.util.Map;

public class SingleServer extends ComputationalModel {

    private final double INITIAL_TIME = 0.0;
    private final double TERMINAL_TIME = 20000.0;

    private int numberOfJobs;
    private int numberOfDepartedJobs;

    private double timeAveragedNumberOfJobs = 0;
    private double timeAveragedServiceTime = 0;

    @Override
    public void initializeSystemStateVariables() {
        numberOfJobs = 0;
        numberOfDepartedJobs = 0;
    }

    @Override
    public void initializeSimulationClock() {
        simulationClock.setTime(INITIAL_TIME);
    }

    @Override
    public void scheduleInitialEvent() {
        scheduleJobArrivalEvent(computeNextJobArrivalTime());
    }

    @Override
    public void updateStatistics() {

        if (!this.isEmpty()) {
            timeAveragedNumberOfJobs += (simulationClock.getNextEventTime() - simulationClock.getTime()) * numberOfJobs;
            timeAveragedServiceTime += (simulationClock.getNextEventTime() - simulationClock.getTime());
        }
    }

    @Override
    public Map<String, Double> getSimulationResults() {

        Map<String, Double> simulationResults = new HashMap<String, Double>();

        System.out.println(numberOfDepartedJobs);
        simulationResults.put("Job", Double.valueOf(numberOfDepartedJobs));
        simulationResults.put("Average service time", timeAveragedServiceTime / numberOfDepartedJobs);
        simulationResults.put("Average number of Job", timeAveragedNumberOfJobs / simulationClock.getTime());
        simulationResults.put("Average wait", timeAveragedNumberOfJobs / numberOfDepartedJobs);
        simulationResults.put("utili", timeAveragedServiceTime / simulationClock.getTime());

        return simulationResults;
    }

    public void scheduleJobArrivalEvent(double nextJobArrivalEventTime) {

        SingleServerEvent jobArrivalEvent = new JobArrivalEvent();
        jobArrivalEvent.setSingleServer(this);
        jobArrivalEvent.setTime(nextJobArrivalEventTime);

        this.eventList.add(jobArrivalEvent);
    }

    public void scheduleJobDepartureEvent() {

        SingleServerEvent jobDepartureEvent = new JobDepartureEvent();
        jobDepartureEvent.setSingleServer(this);
        jobDepartureEvent.setTime(computeNextJobDepartureTime());

        this.eventList.add(jobDepartureEvent);
    }

    public double computeNextJobArrivalTime(){
        return this.simulationClock.getTime() + randomNumberGenerator.getExponentialInterArrivalTime();
    }

    public double computeNextJobDepartureTime(){
        return this.simulationClock.getTime() + randomNumberGenerator.getErlangDistributedServiceTime();
    }

    public double getSimulationTerminationTime(){
        return TERMINAL_TIME;
    }

    public void incrementNumberOfJobs(){
        this.numberOfJobs++;
    }

    public void decrementNumberOfJobs(){
        this.numberOfJobs--;
    }

    public void incrementNumberOfDepartedJob(){
        this.numberOfDepartedJobs++;
    }

    public boolean isEmpty(){
        return this.numberOfJobs == 0;
    }

    public int getNumberOfJobs() {
        return numberOfJobs;
    }
}