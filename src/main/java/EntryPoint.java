import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.model.system.SystemFactory;

public class EntryPoint {

    public static void main(String args[]) {

        NextEventSimulation simulation1 = SystemFactory.buildSystemUsingRoutingAlgorithm1();
        NextEventSimulation simulation2 = SystemFactory.buildSystemUsingRoutingAlgorithm2();

        simulation1.perform();
        simulation2.perform();
    }
}

