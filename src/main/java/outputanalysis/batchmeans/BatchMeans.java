package outputanalysis.batchmeans;

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

        this.batchSize = this.values.size() / 10;

        // Batch splitting
        for (int currentIndex = 0; currentIndex + this.batchSize <= this.values.size(); currentIndex += this.batchSize)
            this.batches.add(new Statistics(this.values.subList(currentIndex, currentIndex + this.batchSize)));

        // Batch means statistics computation
        List<Double> batchMeans = new Vector<Double>();

        for (Statistics statistics : this.batches)
            batchMeans.add(statistics.getMean());

        this.batchMeansStatistic = new Statistics(batchMeans);
    }

    void writeOutputStatisticForMATLABGraphics(int replicationIndex) {

        computeStatistics();

        String outputFileName = String.format("./output/BM_%s.m", name);

        double distanceFromMean = this.batchMeansStatistic.getConfidenceIntervalDistanceFromMean(0.95);

        try {
            FileWriter output = new FileWriter(outputFileName, true);

            output.write(String.format(Locale.US, "plot(%d,%f,'*','color','black')\nhold on\n", replicationIndex, this.batchMeansStatistic.getMean()));
            output.write(String.format(Locale.US, "plot([%d %d],[%f %f],'color','black','LineWidth', 1)\nhold on\n",
                    replicationIndex, replicationIndex, this.batchMeansStatistic.getMean() - distanceFromMean, this.batchMeansStatistic.getMean() + distanceFromMean));

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
