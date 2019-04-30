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

    public static void main(String args[]) {

        File index = new File("./output");
        if (!index.exists()) {
            index.mkdir();
        }


        SimulationRegistry.getInstance().setTotalSimulationReplications(9);

        for (int currentReplicationIndex = 0; currentReplicationIndex <= 9; currentReplicationIndex++){

            SimulationRegistry.getInstance().setCurrentSimulationReplicationIndex(currentReplicationIndex);

            RandomNumberGenerator.getInstance().initialize();
            BatchMeansRegister.getInstance().initialize();
            ScatterPlotRegister.getInstance().initialize();
            HistogramsRegister.getInstance().initialize();

            NextEventSimulation simulation1 = SystemFactory.buildSystemUsingRoutingAlgorithm1();
            NextEventSimulation simulation2 = SystemFactory.buildSystemUsingRoutingAlgorithm2();

            //simulation1.perform();
            simulation2.perform();

        }

        EnsembleStatisticsRegister.getInstance().computeStatisticsWritingOutputData();
    }
}

