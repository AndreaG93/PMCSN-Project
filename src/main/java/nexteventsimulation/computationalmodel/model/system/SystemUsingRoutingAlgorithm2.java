package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.computationalmodel.model.system.component.type.subtype.ControllerUsingRoutingAlgorithm2;

class SystemUsingRoutingAlgorithm2 extends System {

    SystemUsingRoutingAlgorithm2() {
        super();
        this.controller = new ControllerUsingRoutingAlgorithm2(this);
    }
}
