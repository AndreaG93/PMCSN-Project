package nexteventsimulation.computationalmodel.model.system.component;

import nexteventsimulation.computationalmodel.model.system.System;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloud;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloudlet;
import nexteventsimulation.computationalmodel.model.system.component.type.GlobalNetwork;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;
import outputanalysis.batchmeans.BatchMeansRegister;
import outputanalysis.histograms.HistogramsRegister;
import outputanalysis.scatterplots.ScatterPlotRegister;

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

    private double areaNumberOfClass1Jobs = 0.0;
    private double areaNumberOfClass2Jobs = 0.0;
    private double areaServiceTimeClass1Jobs = 0.0;
    private double areaServiceTimeClass2Jobs = 0.0;

    private double areaServiceTime = 0.0;
    private double areaNumberOfJobs = 0.0;

    protected System system;

    public SystemComponent(System system) {
        this.system = system;
    }

    public abstract void scheduleInitialEvent();

    public abstract void scheduleFollowingEventAfterClass1JobArrival();

    public abstract void scheduleFollowingEventAfterClass2JobArrival();

    public abstract void scheduleFollowingEventAfterClass1JobDeparture();

    public abstract void scheduleFollowingEventAfterClass2JobDeparture();

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

        BatchMeansRegister batchMeansRegister = BatchMeansRegister.getInstance();
        ScatterPlotRegister scatterPlotRegister = ScatterPlotRegister.getInstance();
        HistogramsRegister histogramsRegister = HistogramsRegister.getInstance();

        SimulationClock simulationClock = SimulationClock.getInstance();
        String currentComponent = this.getClass().getSimpleName();

        areaNumberOfClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass1Jobs;
        areaServiceTimeClass1Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass1Jobs;

        areaNumberOfClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass2Jobs;
        areaServiceTimeClass2Jobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * numberOfClass2Jobs;

        areaServiceTime += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * (numberOfClass1Jobs + numberOfClass2Jobs);
        areaNumberOfJobs += (simulationClock.getNextEventTime() - simulationClock.getCurrentEventTime()) * (numberOfClass1Jobs + numberOfClass2Jobs);

        batchMeansRegister.addDataToBatch(currentComponent + "_Class1JobsNumber", this.areaNumberOfClass1Jobs / SimulationClock.getInstance().getCurrentEventTime());
        batchMeansRegister.addDataToBatch(currentComponent + "_Class2JobsNumber", this.areaNumberOfClass2Jobs / SimulationClock.getInstance().getCurrentEventTime());
        batchMeansRegister.addDataToBatch(currentComponent + "_JobsNumber", (this.areaNumberOfClass1Jobs + this.areaNumberOfClass2Jobs) / SimulationClock.getInstance().getCurrentEventTime());

        batchMeansRegister.addDataToBatch(currentComponent + "_Class1Throughput", (this.numberOfClass1DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());
        batchMeansRegister.addDataToBatch(currentComponent + "_Class2Throughput", (this.numberOfClass2DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());
        batchMeansRegister.addDataToBatch(currentComponent + "_Throughput", (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());


        if (numberOfClass1DepartedJobs > 0)
            batchMeansRegister.addDataToBatch(currentComponent + "_Class1JobsServiceTime", this.areaServiceTimeClass1Jobs / this.numberOfClass1DepartedJobs);
        else
            batchMeansRegister.addDataToBatch(currentComponent + "_Class1JobsServiceTime", 0.0);

        if (numberOfClass2DepartedJobs > 0)
            batchMeansRegister.addDataToBatch(currentComponent + "_Class2JobsServiceTime", this.areaServiceTimeClass2Jobs / this.numberOfClass2DepartedJobs);
        else
            batchMeansRegister.addDataToBatch(currentComponent + "_Class2JobsServiceTime", 0.0);

        if (numberOfClass1DepartedJobs + numberOfClass2DepartedJobs > 0)
            batchMeansRegister.addDataToBatch(currentComponent + "_JobsServiceTime", this.areaServiceTime / (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs));
        else
            batchMeansRegister.addDataToBatch(currentComponent + "_JobsServiceTime", 0);

        scatterPlotRegister.addData(currentComponent + "_Class1JobsNumber", simulationClock.getCurrentEventTime(), this.areaNumberOfClass1Jobs / SimulationClock.getInstance().getCurrentEventTime());
        scatterPlotRegister.addData(currentComponent + "_Class2JobsNumber", simulationClock.getCurrentEventTime(), this.areaNumberOfClass2Jobs / SimulationClock.getInstance().getCurrentEventTime());
        scatterPlotRegister.addData(currentComponent + "_JobsNumber", simulationClock.getCurrentEventTime(), (this.areaNumberOfJobs) / SimulationClock.getInstance().getCurrentEventTime());

        scatterPlotRegister.addData(currentComponent + "_Class1JobsServiceTime", simulationClock.getCurrentEventTime(), this.areaServiceTimeClass1Jobs / this.numberOfClass1DepartedJobs);
        scatterPlotRegister.addData(currentComponent + "_Class2JobsServiceTime", simulationClock.getCurrentEventTime(), this.areaServiceTimeClass2Jobs / this.numberOfClass2DepartedJobs);
        scatterPlotRegister.addData(currentComponent + "_JobsServiceTime", simulationClock.getCurrentEventTime(), this.areaServiceTime / (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs));

        scatterPlotRegister.addData(currentComponent + "_Throughput", simulationClock.getCurrentEventTime(), (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());
        scatterPlotRegister.addData(currentComponent + "_Class1Throughput", simulationClock.getCurrentEventTime(), this.numberOfClass1DepartedJobs / SimulationClock.getInstance().getCurrentEventTime());
        scatterPlotRegister.addData(currentComponent + "_Class2Throughput", simulationClock.getCurrentEventTime(), this.numberOfClass2DepartedJobs / SimulationClock.getInstance().getCurrentEventTime());

        // SPECIAL
        scatterPlotRegister.addData(currentComponent + "_Special_WaitVersusNumber", (this.areaNumberOfJobs) / SimulationClock.getInstance().getCurrentEventTime(), this.areaServiceTime / (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs));

        // Histograms
        histogramsRegister.addData(currentComponent + "_JobsNumber", this.numberOfClass1Jobs + this.numberOfClass2Jobs);
        histogramsRegister.addData(currentComponent + "_Class1JobsNumber", this.numberOfClass1Jobs);
        histogramsRegister.addData(currentComponent + "_Class2JobsNumber", this.numberOfClass2Jobs);
    }

    public Map<String, Double> getStatistics() {

        String componentName = this.getClass().getSimpleName();

        Map<String, Double> output = new HashMap<String, Double>();

        output.put(String.format("%s_Class1JobsNumber", componentName), this.areaNumberOfClass1Jobs / SimulationClock.getInstance().getCurrentEventTime());
        output.put(String.format("%s_Class2JobsNumber", componentName), this.areaNumberOfClass2Jobs / SimulationClock.getInstance().getCurrentEventTime());

        output.put(String.format("%s_Class1JobsServiceTime", componentName), this.areaServiceTimeClass1Jobs / this.numberOfClass1DepartedJobs);
        output.put(String.format("%s_Class2JobsServiceTime", componentName), this.areaServiceTimeClass2Jobs / this.numberOfClass2DepartedJobs);
        output.put(String.format("%s_JobsServiceTime", componentName), this.areaServiceTime / (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs));

        output.put(String.format("%s_JobsNumber", componentName), this.areaNumberOfJobs / SimulationClock.getInstance().getCurrentEventTime());

        output.put(String.format("%s_Throughput", componentName), (this.numberOfClass1DepartedJobs + this.numberOfClass2DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());
        output.put(String.format("%s_Class1Throughput", componentName), (this.numberOfClass1DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());
        output.put(String.format("%s_Class2Throughput", componentName), (this.numberOfClass2DepartedJobs) / SimulationClock.getInstance().getCurrentEventTime());

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
}