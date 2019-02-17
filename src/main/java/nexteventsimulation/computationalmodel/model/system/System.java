package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.ComputationalModel;
import nexteventsimulation.computationalmodel.model.system.component.type.Controller;
import nexteventsimulation.computationalmodel.model.system.event.Event;
import nexteventsimulation.computationalmodel.model.system.component.Component;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloud;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloudlet;
import nexteventsimulation.computationalmodel.model.system.event.EventFactory;
import nexteventsimulation.utility.SimulatedClock;

import java.util.Map;

public abstract class System extends ComputationalModel {

    private final double simulationStartTime = 0.0;
    private final double simulationStopTime = 20000.0;
    private final int threshold = 20;

    private Component cloud;
    private Component cloudlet;
    Component controller;

    public System() {
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
        this.simulationClock = new SimulatedClock();
        this.simulationClock.setTime(simulationStartTime);
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

    public void scheduleControllerEvent(Class eventClass, double time) {
        if (time < this.simulationStopTime)
            scheduleEvent(eventClass, this.controller, time);
    }

    public void scheduleCloudEvent(Class eventClass, double time) {
        scheduleEvent(eventClass, this.cloud, time);
    }

    public void scheduleCloudletEvent(Class eventClass, double time) {
        scheduleEvent(eventClass, this.cloudlet, time);
    }

    private void scheduleEvent(Class eventClass, Component component, double time) {

        Event event = EventFactory.built(eventClass.getSimpleName());
        event.setTime(time);
        event.setComponent(component);

        this.eventList.add(event);
    }

    public double getActualClockTime() {
        return this.simulationClock.getTime();
    }

    public double getSimulationStopTime() {
        return simulationStopTime;
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
}