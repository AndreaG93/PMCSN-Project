package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.SystemUsingRoutingAlgorithm1;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulatedClock;

public abstract class Component {


    protected double class1AverageArrivalRate;
    protected double class2AverageArrivalRate;
    protected double class1AverageServiceRate;
    protected double class2AverageServiceRate;

    protected int numberOfClass1Jobs;
    protected int numberOfClass2Jobs;
    protected int numberOfClass1DepartedJobs;
    protected int numberOfClass2DepartedJobs;

    protected double timeAveragedNumberOfClass1Jobs = 0;
    protected double timeAveragedNumberOfClass2Jobs = 0;
    protected double timeAveragedServiceTime = 0;

    protected SystemUsingRoutingAlgorithm1 system;

    public void initializeSystemStateVariables(){
        this.numberOfClass1Jobs = 0;
        this.numberOfClass2Jobs = 0;
        this.numberOfClass1DepartedJobs = 0;
        this.numberOfClass2DepartedJobs = 0;
    }







    private boolean isEmpty() {
        return (numberOfClass1Jobs + numberOfClass2Jobs) == 0;
    }






    public void updateStatistics(SimulatedClock clock) {

        if (!this.isEmpty()) {
            timeAveragedNumberOfClass1Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass1Jobs;
            timeAveragedNumberOfClass2Jobs += (clock.getNextEventTime() - clock.getTime()) * numberOfClass2Jobs;
            timeAveragedServiceTime += (clock.getNextEventTime() - clock.getTime());
        }
    }



    protected double getNextClass1JobDepartureTime(){
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(0, this.class1AverageServiceRate);
    }

    protected double getNextClass2JobDepartureTime(){
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(1, this.class2AverageServiceRate);
    }

    protected double getNextClass1JobArrivalTime(){
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(0, this.class1AverageArrivalRate);
    }

    protected double getNextClass2JobArrivalTime(){
        SimulatedClock simulationClock = this.system.getSimulationClock();
        RandomNumberGenerator randomNumberGenerator = this.system.getRandomNumberGenerator();

        return simulationClock.getTime() + randomNumberGenerator.getExponential(0, this.class2AverageArrivalRate);
    }

    public abstract void updateStatusAfterClass1JobArrival();

    public abstract void updateStatusAfterClass1JobDeparture();

    public abstract void updateStatusAfterClass2JobArrival();

    public abstract void updateStatusAfterClass2JobDeparture();

    public abstract void scheduleFollowingEventAfterClass1JobArrival();

    public abstract void scheduleFollowingEventAfterClass2JobArrival();

    public int getNumberOfClass1Jobs() {
        return numberOfClass1Jobs;
    }

    public int getNumberOfClass2Jobs() {
        return numberOfClass2Jobs;
    }
}