import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.ComputationalModelFactory;

public class EntryPoint {

    public static void main(String args[]) {

        NextEventSimulation simulation1 = ComputationalModelFactory.built("System", "UsingRoutingAlgorithm1");
        NextEventSimulation simulation2 = ComputationalModelFactory.built("System", "UsingRoutingAlgorithm2");

        if (simulation1 != null)
            simulation1.perform();

        //if (simulation2 != null)
        //    simulation2.perform();

    }
}

