package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;
import statistics.BatchMeansManagerRegister;

import java.util.HashMap;
import java.util.Map;


public abstract class SystemComponent {

    protected double class1AverageArrivalRate;
    protected double class2AverageArrivalRate;
    protected double class1AverageServiceRate;
    protected double class2AverageServiceRate;

    private int numberOfClass1Jobs;
    private int numberOfClass2Jobs;
    private int numberOfClass1DepartedJobs;
    private int numberOfClass2DepartedJobs;

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

    public void updateStatusAfterClass1JobArrival() {
        this.numberOfClass1Jobs++;
    }

    public void updateStatusAfterClass1JobDeparture() {
        this.numberOfClass1Jobs--;
        this.numberOfClass1DepartedJobs++;
    }

    public void updateStatusAfterClass2JobArrival() {
        this.numberOfClass2Jobs++;
    }

    public void updateStatusAfterClass2JobDeparture() {
        this.numberOfClass2Jobs--;
        this.numberOfClass2DepartedJobs++;
    }

    protected double getNextClass1JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(0, Math.pow(this.class1AverageArrivalRate, -1));
    }

    protected double getNextClass1JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(1, Math.pow(this.class1AverageServiceRate, -1));
    }

    protected double getNextClass2JobInterArrivalTime() {
        return RandomNumberGenerator.getInstance().getExponential(2, Math.pow(this.class2AverageArrivalRate, -1));
    }

    protected double getNextClass2JobServiceTime() {
        return RandomNumberGenerator.getInstance().getExponential(3, Math.pow(this.class2AverageServiceRate, -1));
    }

    public void updateStatistics() {

        BatchMeansManagerRegister batchMeansManagerRegister = BatchMeansManagerRegister.getInstance();

        SimulationClock simulationClock = SimulationClock.getInstance();

        String currentComponent = this.getClass().getSimpleName();

        //if (numberOfClass1Jobs != 0) {

            areaNumberOfClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass1Jobs;
            areaServiceTimeClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime());

            batchMeansManagerRegister.getBatchMeansManager(currentComponent + "Class1Population").add(this.areaNumberOfClass1Jobs / SimulationClock.getInstance().getCurrentEventTime());

            if (this.numberOfClass1DepartedJobs != 0)
                batchMeansManagerRegister.getBatchMeansManager(currentComponent + "Class1ServiceTime").add(this.areaNumberOfClass1Jobs / this.numberOfClass1DepartedJobs);
       // }

        //if (numberOfClass2Jobs != 0) {

            areaNumberOfClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass2Jobs;
            areaServiceTimeClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime());

            batchMeansManagerRegister.getBatchMeansManager(currentComponent + "Class2Population").add(this.areaNumberOfClass2Jobs / SimulationClock.getInstance().getCurrentEventTime());

            if (this.numberOfClass2DepartedJobs != 0)
                batchMeansManagerRegister.getBatchMeansManager(currentComponent + "Class2ServiceTime").add(this.areaNumberOfClass2Jobs / this.numberOfClass2DepartedJobs);
        //}


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
        output.put(String.format("[%s] E[T_1]", this.getClass().getSimpleName()), this.areaNumberOfClass1Jobs / this.numberOfClass1DepartedJobs);
        output.put(String.format("[%s] E[T_2]", this.getClass().getSimpleName()), this.areaNumberOfClass2Jobs / this.numberOfClass2DepartedJobs);


        output.put(String.format("[%s] E[X_1]", this.getClass().getSimpleName()), this.areaServiceTimeClass1Jobs / SimulationClock.getInstance().getCurrentEventTime());
        output.put(String.format("[%s] E[X_2]", this.getClass().getSimpleName()), this.areaServiceTimeClass2Jobs / SimulationClock.getInstance().getCurrentEventTime());


        return output;
    }

    public int getNumberOfClass1Jobs() {
        return this.numberOfClass1Jobs;
    }

    public int getNumberOfClass2Jobs() {
        return this.numberOfClass2Jobs;
    }

    public void decreaseNumberOfClass2Jobs() {
        this.numberOfClass2Jobs--;
    }

    public abstract void scheduleInitialEvent();

    public abstract void scheduleFollowingEventAfterClass1JobArrival();

    public abstract void scheduleFollowingEventAfterClass2JobArrival();

    public abstract void scheduleFollowingEventAfterClass1JobDeparture();

    public abstract void scheduleFollowingEventAfterClass2JobDeparture();
}