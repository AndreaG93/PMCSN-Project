package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm1;

class SystemUsingRoutingAlgorithm1 extends System {

    SystemUsingRoutingAlgorithm1() {
        super();
        this.controller = new ControllerUsingRoutingAlgorithm1(this);
    }
}
