import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.model.system.SystemFactory;
import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationRegistry;
import outputanalysis.batchmeans.BatchMeansRegister;
import outputanalysis.ensemblestatistics.EnsembleStatisticsRegister;
import outputanalysis.histograms.HistogramsRegister;
import outputanalysis.scatterplots.ScatterPlotRegister;

import java.io.File;

public class EntryPoint {

    private static int numberOfReplications = 9;
    private static int algorithm = 1;
    private static NextEventSimulation simulation;

    public static void main(String args[]) {

        File index = new File("./output");
        if (!index.exists()) {
            index.mkdir();
        }

        SimulationRegistry.getInstance().setTotalSimulationReplications(numberOfReplications - 1);

        for (int currentReplicationIndex = 0; currentReplicationIndex <= (numberOfReplications - 1); currentReplicationIndex++) {

            if (algorithm == 1) {
                simulation = SystemFactory.buildSystemUsingRoutingAlgorithm1();
            } else
                simulation = SystemFactory.buildSystemUsingRoutingAlgorithm2();


            SimulationRegistry.getInstance().setCurrentSimulationReplicationIndex(currentReplicationIndex);

            RandomNumberGenerator.getInstance().initialize();
            BatchMeansRegister.getInstance().initialize();
            ScatterPlotRegister.getInstance().initialize();
            HistogramsRegister.getInstance().initialize();

            simulation.perform();
        }

        EnsembleStatisticsRegister.getInstance().computeStatisticsWritingOutputData();
    }
}

