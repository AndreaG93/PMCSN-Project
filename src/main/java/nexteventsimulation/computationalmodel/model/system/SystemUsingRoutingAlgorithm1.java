package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm1;

public class SystemUsingRoutingAlgorithm1 extends System {

    public SystemUsingRoutingAlgorithm1() {
        super();
        this.controller = new ControllerUsingRoutingAlgorithm1();
    }
}