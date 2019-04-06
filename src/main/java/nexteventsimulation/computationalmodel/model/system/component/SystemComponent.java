package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationLogFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SystemComponent {

    private static final Logger LOGGER = SimulationLogFactory.getLogger();

    protected double class1AverageArrivalRate;
    protected double class2AverageArrivalRate;
    protected double class1AverageServiceRate;
    protected double class2AverageServiceRate;

    protected int numberOfClass1Jobs;
    protected int numberOfClass2Jobs;
    protected int numberOfClass1DepartedJobs;
    protected int numberOfClass2DepartedJobs;

    private double areaNumberOfClass1Jobs = 0;
    private double areaNumberOfClass2Jobs = 0;
    private double areaServiceTimeClass1Jobs = 0;
    private double areaServiceTimeClass2Jobs = 0;

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

    public abstract void scheduleFollowingEventAfterClass1JobArrival();

    public abstract void scheduleFollowingEventAfterClass2JobArrival();

    protected double getNextClass1JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(0, Math.pow(this.class1AverageArrivalRate,-1));
    }

    protected double getNextClass1JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(1, Math.pow(this.class1AverageServiceRate,-1));
    }

    protected double getNextClass2JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(2, Math.pow(this.class2AverageArrivalRate,-1));
    }

    protected double getNextClass2JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(3, Math.pow(this.class2AverageServiceRate,-1));
    }

    public void updateStatistics() {

        SimulationClock simulationClock = SimulationClock.getInstance();

        if (numberOfClass1Jobs != 0) {

            areaNumberOfClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass1Jobs;

            areaServiceTimeClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime());
        }

        if (numberOfClass2Jobs != 0) {

            areaNumberOfClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass2Jobs;

            areaServiceTimeClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime());
        }
    }

    public Map<String, Double> getStatistics() {

        double averageNumberOfClass1Job = this.areaNumberOfClass1Jobs / SimulationClock.getInstance().getCurrentEventTime();

        double averageNumberOfClass2Job = this.areaNumberOfClass2Jobs / SimulationClock.getInstance().getCurrentEventTime();

        double averageClass1JobServiceTime = this.areaServiceTimeClass1Jobs / this.numberOfClass1DepartedJobs;

        double averageClass2JobServiceTime = this.areaServiceTimeClass2Jobs / this.numberOfClass2DepartedJobs;

        Map<String, Double> output = new HashMap<String, Double>();

        output.put(String.format("[%s] E[N_1]", this.getClass().getSimpleName()), averageNumberOfClass1Job);
        output.put(String.format("[%s] E[N_2]", this.getClass().getSimpleName()), averageNumberOfClass2Job);
        output.put(String.format("[%s] E[S_1]", this.getClass().getSimpleName()), averageClass1JobServiceTime);
        output.put(String.format("[%s] E[S_2]", this.getClass().getSimpleName()), averageClass2JobServiceTime);

        return output;
    }

    public int getNumberOfClass1Jobs() {
        return this.numberOfClass1Jobs;
    }

    public int getNumberOfClass2Jobs() {
        return this.numberOfClass2Jobs;
    }

    public void decreaseNumberOfClass2Jobs(){
        this.numberOfClass2Jobs--;
    }

    public void logChanges(){

        String message = String.format("[ACTUAL CHANGES]: %s, [N_1]: %s, [N_2]: %s",
                this.getClass().getSimpleName(),
                String.valueOf(this.numberOfClass1Jobs),
                String.valueOf(this.numberOfClass2Jobs));

        LOGGER.log(Level.INFO, message);
    }
}