import nexteventsimulation.NextEventSimulation;

import nexteventsimulation.computationalmodel.model.system.SystemFactory;
import nexteventsimulation.utility.RandomNumberGenerator;
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

        for (int currentReplicationIndex = 0; currentReplicationIndex < 10; currentReplicationIndex++){

            RandomNumberGenerator.getInstance().initialize(currentReplicationIndex);

            BatchMeansRegister.getInstance().setReplicationIndex(currentReplicationIndex);
            ScatterPlotRegister.getInstance().setReplicationIndex(currentReplicationIndex);
            HistogramsRegister.getInstance().setReplicationIndex(currentReplicationIndex);

            NextEventSimulation simulation1 = SystemFactory.buildSystemUsingRoutingAlgorithm1();
            NextEventSimulation simulation2 = SystemFactory.buildSystemUsingRoutingAlgorithm2();

            simulation1.perform();
            //simulation2.perform();

        }

        EnsembleStatisticsRegister.getInstance().computeStatisticsWritingOutputData();
    }
}

