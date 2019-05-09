import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.model.system.SystemFactory;
import nexteventsimulation.utility.FileManagement;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationRegistry;
import outputanalysis.batchmeans.BatchMeansRegister;
import outputanalysis.ensemblestatistics.EnsembleStatisticsRegister;
import outputanalysis.histograms.HistogramsRegister;
import outputanalysis.scatterplots.ScatterPlotRegister;

public class EntryPoint {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("In order to perform simulation, please specify which routing algorithm you want to use!");
            System.exit(-1);
        }

        int routingAlgorithmId = Integer.valueOf(args[0]);
        String outputDirectoryName = "./SimulationOutputUsingRoutingAlgorithm" + routingAlgorithmId;

        SimulationRegistry.getInstance().setOutputDirectoryName(outputDirectoryName);
        SimulationRegistry.getInstance().setTotalSimulationReplications(9);

        FileManagement.createOrPurgeDirectory(outputDirectoryName);
        startSimulation(routingAlgorithmId);
    }

    private static void startSimulation(int routingAlgorithmId) {

        NextEventSimulation simulation;
        int numberOfReplications =  SimulationRegistry.getInstance().getTotalSimulationReplications();

        System.out.println("Start simulation using routing algorithm #" + routingAlgorithmId);

        for (int currentReplicationIndex = 0; currentReplicationIndex <= numberOfReplications; currentReplicationIndex++) {

            if (routingAlgorithmId == 1) {
                simulation = SystemFactory.buildSystemUsingRoutingAlgorithm1();
            } else
                simulation = SystemFactory.buildSystemUsingRoutingAlgorithm2();

            SimulationRegistry.getInstance().setCurrentSimulationReplicationIndex(currentReplicationIndex);

            RandomNumberGenerator.getInstance().initialize();
            BatchMeansRegister.getInstance().initialize();
            ScatterPlotRegister.getInstance().initialize();
            HistogramsRegister.getInstance().initialize();

            System.out.print("Replication #" + currentReplicationIndex + " running...");
            simulation.perform();
            System.out.println("done!");
        }

        EnsembleStatisticsRegister.getInstance().computeStatisticsWritingOutputData();

        System.out.println("Simulation done! Output data are stored in " + SimulationRegistry.getInstance().getOutputDirectoryName());
    }
}

