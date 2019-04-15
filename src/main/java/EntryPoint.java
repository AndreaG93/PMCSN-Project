import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.model.system.SystemFactory;
import nexteventsimulation.utility.RandomNumberGenerator;
import statistics.BatchMeansManagerRegister;

public class EntryPoint {

    public static void main(String args[]) {

        int replication = 10;

        for (int currentReplicationIndex = 0; currentReplicationIndex < 10; currentReplicationIndex++){

            RandomNumberGenerator.getInstance().setReplicationIndex(currentReplicationIndex);
            BatchMeansManagerRegister.getInstance().setReplicationIndex(currentReplicationIndex);

            NextEventSimulation simulation1 = SystemFactory.buildSystemUsingRoutingAlgorithm1();
            NextEventSimulation simulation2 = SystemFactory.buildSystemUsingRoutingAlgorithm2();

            simulation1.perform();
            //simulation2.perform();

        }
    }
}

