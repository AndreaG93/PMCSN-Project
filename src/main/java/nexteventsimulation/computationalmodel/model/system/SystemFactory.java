package nexteventsimulation.computationalmodel.model.system;

import nexteventsimulation.NextEventSimulation;

public class SystemFactory {

    public static NextEventSimulation buildSystemUsingRoutingAlgorithm1() {
        return new SystemUsingRoutingAlgorithm1();
    }

    public static NextEventSimulation buildSystemUsingRoutingAlgorithm2() {
        return new SystemUsingRoutingAlgorithm2();
    }
}
