package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry.SimulationAnalyticValueRegistryAlgorithm2;
import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm2;
import nexteventsimulation.utility.SimulationRegistry;

class SystemUsingRoutingAlgorithm2 extends System {

    SystemUsingRoutingAlgorithm2() {
        super();

        this.controller = new ControllerUsingRoutingAlgorithm2(this);

        SimulationRegistry.getInstance().setAnalyticalValueRegistry(SimulationAnalyticValueRegistryAlgorithm2.getInstance());
    }
}
