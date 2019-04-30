package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.ComputationalModel;
import nexteventsimulation.computationalmodel.model.system.component.type.GlobalNetwork;
import nexteventsimulation.computationalmodel.model.system.event.SystemEvent;
import nexteventsimulation.computationalmodel.model.system.component.SystemComponent;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloud;
import nexteventsimulation.computationalmodel.model.system.component.type.Cloudlet;
import nexteventsimulation.computationalmodel.model.system.event.type.Class2JobDeparture;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationEvent;

import java.util.Map;

public abstract class System extends ComputationalModel {

    private SystemComponent cloud;
    private SystemComponent cloudlet;
    private SystemComponent globalNetwork;
    SystemComponent controller;

    public System() {
        this.cloud = new Cloud(this);
        this.cloudlet = new Cloudlet(this);
        this.globalNetwork = new GlobalNetwork(this);
    }

    @Override
    protected void initializeSystemStateVariables() {
        this.cloud.initializeSystemStateVariables();
        this.cloudlet.initializeSystemStateVariables();
        this.globalNetwork.initializeSystemStateVariables();
    }

    @Override
    protected void initializeSimulationClock() {
        SimulationClock.getInstance().setCurrentEventTime(0.0);
        SimulationClock.getInstance().setNextEventTime(0.0);
    }

    @Override
    protected void scheduleInitialEvent() {
        this.globalNetwork.scheduleInitialEvent();
    }

    @Override
    protected void updateStatistics() {

        this.controller.updateStatistics();
        this.cloud.updateStatistics();
        this.cloudlet.updateStatistics();
        this.globalNetwork.updateStatistics();

    }

    @Override
    protected Map<String, Double> getSimulationResults() {

        Map<String, Double> output0 = this.globalNetwork.getStatistics();
        Map<String, Double> output1 = this.cloudlet.getStatistics();
        Map<String, Double> output2 = this.cloud.getStatistics();
        Map<String, Double> output3 = this.controller.getStatistics();

        output0.putAll(output1);
        output0.putAll(output2);

        if (!output3.isEmpty())
            output0.putAll(output3);

        return output0;
    }

    public int getThreshold() {
        return 20;
    }

    public int getNumberOfClass1JobOnCloudlet() {
        return this.cloudlet.getNumberOfClass1Jobs();
    }

    public int getNumberOfClass2JobOnCloudlet() {
        return this.cloudlet.getNumberOfClass2Jobs();
    }

    public void scheduleEventOnCloud(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.cloud);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        this.simulationEventList.schedule(event);
    }

    public void scheduleEventOnCloudlet(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.cloudlet);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        this.simulationEventList.schedule(event);
    }

    public void scheduleEventOnController(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.controller);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        this.simulationEventList.schedule(event);
    }

    public void scheduleEventOnGlobalNetwork(SystemEvent event) {

        event.setSystemComponent(this.globalNetwork);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime());

        this.simulationEventList.schedule(event);
    }

    public void scheduleEventOnGlobalNetwork(SystemEvent event, double waitTime) {

        event.setSystemComponent(this.globalNetwork);
        event.setStartTime(SimulationClock.getInstance().getCurrentEventTime() + waitTime);

        if (event.getStartTime() < 12000.0)
            this.simulationEventList.schedule(event);
    }

    public void removeFarthermostCloudletClass2JobDeparture() {

        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();

        while (true) {
            for (SimulationEvent event : this.simulationEventList)
                if (event instanceof Class2JobDeparture && ((SystemEvent) event).getSystemComponent() instanceof Cloudlet)
                    if (randomNumberGenerator.getUniformBetween(0, 100) <= 1) {

                        this.simulationEventList.remove(event);
                        this.cloudlet.decreaseNumberOfClass2Jobs();
                        return;
                    }
        }
    }
}
