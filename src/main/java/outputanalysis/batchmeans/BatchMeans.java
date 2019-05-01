package outputanalysis.batchmeans;

import nexteventsimulation.utility.RandomNumberGenerator;
import nexteventsimulation.utility.SimulationRegistry;
import outputanalysis.Statistics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class BatchMeans {

    private String name;
    private List<Double> values;
    private List<Statistics> batches;

    private int batchSize;
    private Statistics batchMeansStatistic;

    BatchMeans(String name) {

        this.values = new Vector<Double>();
        this.batches = new Vector<Statistics>();

        this.name = name;
    }

    public void add(double value) {
        this.values.add(value);
    }


    private void computeStatistics() {

        int currentIndex = 0;
        while (currentIndex < this.values.size()) {

            List<Double> batch = new Vector<Double>();

            for (;currentIndex < this.values.size();){

                batch.add(this.values.get(currentIndex));
                currentIndex += 30;

                if (batch.size() == 4096){
                    this.batches.add(new Statistics(batch));
                    break;
                }
            }
        }

        // Batch means statistics computation
        List<Double> batchMeans = new Vector<Double>();

        for (Statistics statistics : this.batches)
            batchMeans.add(statistics.getMean());

        this.batchMeansStatistic = new Statistics(batchMeans);
    }

    void writeOutputStatisticForMATLABGraphics(int replicationIndex) {

        computeStatistics();

        double analyticalValue = SimulationRegistry.getInstance().getAnalyticalValueRegistry().getAnalyticalValue(this.name);

        String outputFileName = String.format("./output/BM_%s.m", name);

        double distanceFromMean = this.batchMeansStatistic.getConfidenceIntervalDistanceFromMean(0.95);

        try {
            FileWriter output = new FileWriter(outputFileName, true);

            if(SimulationRegistry.getInstance().isFirstSimulationReplications()) {
                output.write("h=figure\nxlabel('Replication ID')\n");
                output.write(String.format(Locale.US,"xlim([-1 %d])\nhold on\n", SimulationRegistry.getInstance().getTotalSimulationReplications()+1));
            }

            output.write(String.format(Locale.US, "plot(%d,%f,'*','color','black','HandleVisibility','off')\nhold on\n", replicationIndex, this.batchMeansStatistic.getMean()));
            output.write(String.format(Locale.US, "plot([%d %d],[%f %f],'color','black','LineWidth', 1,'HandleVisibility','off')\nhold on\n",
                    replicationIndex, replicationIndex, this.batchMeansStatistic.getMean() - distanceFromMean, this.batchMeansStatistic.getMean() + distanceFromMean));

            if (SimulationRegistry.getInstance().AreSimulationReplicationsTerminate()) {
                output.write(String.format(Locale.US, "yline(%f,'DisplayName','Analytical value')\nlegend('location','best')\n", analyticalValue));
                output.write(String.format("saveas(h, '%s', 'png')\n", this.getClass().getSimpleName() + this.name));
            }

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBatchSize(int size) {
        this.batchSize = size;
    }
}
