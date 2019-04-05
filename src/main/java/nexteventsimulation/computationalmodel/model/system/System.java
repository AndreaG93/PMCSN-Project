package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.ComputationalModel;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloud;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloudlet;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobDeparture;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationEvent;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class System extends ComputationalModel {

    private final double simulationStartTime = 0.0;
    private final double simulationStopTime = 20000.0;
    private final int threshold = 20;

    private SystemComponent cloud;
    private SystemComponent cloudlet;
    SystemComponent controller;

    public System() {
        this.eventList = new PriorityQueue<SimulationEvent>();

        this.cloud = new Cloud(this);
        this.cloudlet = new Cloudlet(this);
    }

    @Override
    protected void initializeSystemStateVariables() {
        this.cloud.initializeSystemStateVariables();
        this.cloudlet.initializeSystemStateVariables();
    }

    @Override
    protected void initializeSimulationClock() {
        SimulationClock.getInstance().setCurrentEventTime(simulationStartTime);
    }

    @Override
    protected void scheduleInitialEvent() {
        this.controller.scheduleInitialEvent();
    }

    @Override
    protected void updateStatistics() {
        this.cloud.updateStatistics();
        this.cloudlet.updateStatistics();
    }

    @Override
    protected Map<String, Double> getSimulationResults() {
        return null;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getNumberOfClass1JobOnCloudlet() {
        return this.cloudlet.getNumberOfClass1Jobs();
    }

    public int getNumberOfClass2JobOnCloudlet() {
        return this.cloudlet.getNumberOfClass1Jobs();
    }

    public void scheduleEventOnCloud(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.cloudlet);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        this.eventList.add(event);
    }

    public void scheduleEventOnCloudlet(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.cloudlet);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        this.eventList.add(event);
    }

    public void scheduleEventOnController(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.cloudlet);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        if (event.getStartTime() < this.simulationStopTime)
            this.eventList.add(event);
    }

    public void removeFarthermostCloudletClass2JobDeparture() {

        SimulationEvent targetEvent = null;

        for (SimulationEvent event : this.eventList) {
            if (event instanceof Class2JobDeparture && ((SystemEvent) event).getSystemComponent() instanceof Cloudlet)
                targetEvent = event;
        }

        if (targetEvent != null)
            this.eventList.remove(targetEvent);
    }
}