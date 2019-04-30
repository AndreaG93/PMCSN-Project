package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry.SimulationAnalyticValueRegistryAlgorithm1;
import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm1;
import nexteventsimulation.utility.SimulationAnalyticValueRegistry;
import nexteventsimulation.utility.SimulationRegistry;

class SystemUsingRoutingAlgorithm1 extends System {

    SystemUsingRoutingAlgorithm1() {
        super();

        this.controller = new ControllerUsingRoutingAlgorithm1(this);

        SimulationRegistry.getInstance().setAnalyticalValueRegistry(SimulationAnalyticValueRegistryAlgorithm1.getInstance());
    }
}
