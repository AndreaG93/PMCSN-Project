package nexteventsimulation.models.cloudsystemusingalgorithm1;

import nexteventsimulation.models.ComputationalModel;
import nexteventsimulation.models.cloudsystemusingalgorithm1.component.Component;
import nexteventsimulation.models.cloudsystemusingalgorithm1.component.type.Cloud;
import nexteventsimulation.models.cloudsystemusingalgorithm1.component.type.Cloudlet;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.Event;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.type.Class1JobArrivalOnController;
import nexteventsimulation.models.cloudsystemusingalgorithm1.event.type.Class2JobArrivalOnController;
import nexteventsimulation.models.singleserver.event.SingleServerEvent;
import nexteventsimulation.models.singleserver.event.type.JobArrivalEvent;
import nexteventsimulation.utility.SimulatedClock;

import java.util.Map;

public class SystemUsingAlgorithm1 extends ComputationalModel {

    private final double CLASS_1_AVERAGE_ARRIVAL_RATE = 0.45;
    private final double CLASS_2_AVERAGE_ARRIVAL_RATE = 0.27;
    private final double INITIAL_TIME = 0.0;
    private final double TERMINAL_TIME = 20000.0;
    private final int THRESHOLD = 20;

    private Component cloud;
    private Component cloudlet;

    public SystemUsingAlgorithm1() {
        this.cloud = new Cloud();
        this.cloudlet = new Cloudlet();
    }

    @Override
    protected void initializeSystemStateVariables() {
    }

    @Override
    protected void initializeSimulationClock() {
        this.simulationClock = new SimulatedClock();
        this.simulationClock.setTime(INITIAL_TIME);
    }

    @Override
    protected void scheduleInitialEvent() {

        double futureClass1JobArrivalTime = this.randomNumberGenerator.getExponentialInterArrivalTime();
        double futureClass2JobArrivalTime = this.randomNumberGenerator.getExponentialInterArrivalTime();

        scheduleClass1JobArrivalEventOnController(futureClass1JobArrivalTime);
        scheduleClass2JobArrivalEventOnController(futureClass2JobArrivalTime);
    }

    @Override
    protected void updateStatistics() {
    }

    @Override
    protected Map<String, Double> getSimulationResults() {
        return null;
    }

    public void scheduleClass1JobArrivalEventOnController(double nextClass1JobArrivalTime) {

        Event futureEvent = new Class1JobArrivalOnController();
        futureEvent.setSystem(this);
        futureEvent.setTime(nextClass1JobArrivalTime);

        this.eventList.add(futureEvent);
    }

    public void scheduleClass2JobArrivalEventOnController(double nextClass2JobArrivalTime) {

        Event futureEvent = new Class2JobArrivalOnController();
        futureEvent.setSystem(this);
        futureEvent.setTime(nextClass2JobArrivalTime);

        this.eventList.add(futureEvent);
    }

    public void scheduleEvent(Event event) {
        this.eventList.add(event);
    }

    public double computeNextJobArrivalTime() {
        return this.simulationClock.getTime() + randomNumberGenerator.getExponentialInterArrivalTime();
    }

    public double computeNextJobDepartureTime() {
        return this.simulationClock.getTime() + randomNumberGenerator.getErlangDistributedServiceTime();
    }
}