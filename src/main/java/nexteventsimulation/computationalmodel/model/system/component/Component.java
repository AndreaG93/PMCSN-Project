package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.SystemUsingRoutingAlgorithm1;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulatedClock;

import java.util.Map;

public abstract class Component {

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

    public Component(System system) {
        this.system = system;
    }

    public void initializeSystemStateVariables() {
        this.numberOfClass1Jobs = 0;
        this.numberOfClass2Jobs = 0;
        this.numberOfClass1DepartedJobs = 0;
        this.numberOfClass2DepartedJobs = 0;
    }


    private boolean isEmpty() {
        return (numberOfClass1Jobs + numberOfClass2Jobs) == 0;
    }


    public void updateStatistics() {

        SimulatedClock clock = this.system.getSimulationClock();

        if (!this.isEmpty()) {
            timeAveragedNumberOfClass1Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass1Jobs;
            timeAveragedNumberOfClass2Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass2Jobs;
            //timeAveragedServiceTime += (clock.getNextEventTime() - clock.getTime());
        }
    }

    public Map<String, Double> getStatistics(){


        SimulatedClock clock = this.system.getSimulationClock();

        java.lang.System.out.println("Average Number class 1 jobs" +
                String.format(timeAveragedNumberOfClass1Jobs / clock.getTime()));



    }


    protected double getNextClass1JobArrivalTime() {
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(0, this.class1AverageArrivalRate);
    }

    protected double getNextClass1JobDepartureTime() {
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(1, this.class1AverageServiceRate);
    }

    protected double getNextClass2JobArrivalTime() {
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(2, this.class2AverageArrivalRate);
    }

    protected double getNextClass2JobDepartureTime() {
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(3, this.class2AverageServiceRate);
    }

    public abstract void updateStatusAfterClass1JobArrival();

    public abstract void updateStatusAfterClass1JobDeparture();

    public abstract void updateStatusAfterClass2JobArrival();

    public abstract void updateStatusAfterClass2JobDeparture();

    public abstract void scheduleFollowingEventAfterClass1JobArrival();

    public abstract void scheduleFollowingEventAfterClass2JobArrival();

    public abstract void scheduleInitialEvent();

    public int getNumberOfClass1Jobs() {
        return numberOfClass1Jobs;
    }

    public int getNumberOfClass2Jobs() {
        return numberOfClass2Jobs;
    }
}