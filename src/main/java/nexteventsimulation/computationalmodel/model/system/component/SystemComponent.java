package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.event.SystemEventFactory;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;

import java.util.Map;

public abstract class SystemComponent {

    protected double class1AverageArrivalRate;
    protected double class2AverageArrivalRate;
    protected double class1AverageServiceRate;
    protected double class2AverageServiceRate;

    protected int numberOfClass1Jobs;
    protected int numberOfClass2Jobs;
    protected int numberOfClass1DepartedJobs;
    protected int numberOfClass2DepartedJobs;

    private double timeAveragedNumberOfClass1Jobs = 0;
    private double timeAveragedNumberOfClass2Jobs = 0;
    private double timeAveragedServiceTime = 0;

    protected System system;

    public SystemComponent(System system) {
        this.system = system;
    }

    public void initializeSystemStateVariables() {
        this.numberOfClass1Jobs = 0;
        this.numberOfClass2Jobs = 0;
        this.numberOfClass1DepartedJobs = 0;
        this.numberOfClass2DepartedJobs = 0;
    }

    public abstract void updateStatusAfterClass1JobArrival();

    public abstract void updateStatusAfterClass1JobDeparture();

    public abstract void updateStatusAfterClass2JobArrival();

    public abstract void updateStatusAfterClass2JobDeparture();

    public abstract void scheduleInitialEvent();

    protected double getNextClass1JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(0, this.class1AverageArrivalRate);
    }

    private double getNextClass1JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(1, this.class1AverageServiceRate);
    }

    protected double getNextClass2JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(2, this.class2AverageArrivalRate);
    }

    private double getNextClass2JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(3, this.class2AverageServiceRate);
    }

    public void scheduleFollowingEventAfterClass1JobArrival() {

        SystemEvent event = SystemEventFactory.buildClass1JobDeparture();
        this.system.scheduleEventOnCloud(event, this.getNextClass1JobServiceTime());
    }

    public void scheduleFollowingEventAfterClass2JobArrival() {

        SystemEvent event = SystemEventFactory.buildClass2JobDeparture();
        this.system.scheduleEventOnCloud(event, this.getNextClass2JobServiceTime());
    }

    public void updateStatistics() {

        SimulationClock simulationClock = SimulationClock.getInstance();

        if (!this.isEmpty()) {
            timeAveragedNumberOfClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass1Jobs;
            timeAveragedNumberOfClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass2Jobs;
        }
    }












    private boolean isEmpty() {
        return (numberOfClass1Jobs + numberOfClass2Jobs) == 0;
    }



    public Map<String, Double> getStatistics() {

/*
        SimulationClock clock = this.system.getSimulationClock();

        java.lang.System.out.println("Average Number class 1 jobs" +
                String.format(timeAveragedNumberOfClass1Jobs / clock.getStartTime()));

*/
        return null;

    }






    public int getNumberOfClass1Jobs() {
        return numberOfClass1Jobs;
    }

    public int getNumberOfClass2Jobs() {
        return numberOfClass2Jobs;
    }


}