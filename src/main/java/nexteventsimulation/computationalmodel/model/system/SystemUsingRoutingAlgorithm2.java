package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm2;

public class SystemUsingRoutingAlgorithm2 extends System {

    public SystemUsingRoutingAlgorithm2() {
        super();
        this.controller = new ControllerUsingRoutingAlgorithm2();
    }
}