package outputanalysis.ensemblestatistics;

import outputanalysis.Statistics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

class EnsembleStatistics {

    private String name;
    private List<Double> values;
    private Statistics ensembleStatistics;

    EnsembleStatistics(String name) {
        this.values = new Vector<Double>();
        this.name = name;
    }

    void add(double value) {
        this.values.add(value);
    }

    void computeEnsembleStatisticsWritingOutputData() {

        this.ensembleStatistics = new Statistics(this.values);

        try {
            writeEnsembleOutputStatistic();
            writeEnsembleOutputStatisticForMATLABGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeEnsembleOutputStatistic() throws IOException {

        FileWriter output = new FileWriter(String.format("./output/ensembleStatistics_%s", this.name));

        output.write(String.format(Locale.US, "Metric name: %s \n\n", this.name));

        for (int replicationNumber = 0; replicationNumber < this.values.size(); replicationNumber++)
            output.write(String.format(Locale.US, "Replication n. %d                   : %f \n", replicationNumber, this.values.get(replicationNumber)));

        output.write(String.format(Locale.US, "\nEnsemble average point estimate    : %f \n", this.ensembleStatistics.getMean()));
        output.write(String.format(Locale.US, "\nEnsemble average interval estimate : %f \n", this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95)));

        output.flush();
        output.close();
    }

    private void writeEnsembleOutputStatisticForMATLABGraphics() throws IOException {

        FileWriter output = new FileWriter(String.format("./output/ensembleStatistics_%s.m", this.name));
        
        double distanceFromMean = this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95);

        // X
        output.write("x = [ ");
        for (double value : this.values){
            output.write(String.format(Locale.US, " %f ", value));
        }
        output.write(" ];\n");

        // Y
        output.write("y = [ ");
        for (int i = 0; i < this.values.size(); i++){
            output.write("0 ");
        }
        output.write(" ];\n");

        // Add scatter plot...

        output.write("hold on\nylim([-0.01 0.01])\n");
        output.write("scatter(x,y,'filled','DisplayName','Transient statistic values')\n");
        output.write("%scatter(0,0,'o','k','DisplayName','Analytical values')\n");


        output.write(String.format(Locale.US, "plot([%f %f],[0 0],'color','red','LineWidth', 1,'DisplayName', 'Confidence interval')\n",
                this.ensembleStatistics.getMean() - distanceFromMean, this.ensembleStatistics.getMean() + distanceFromMean));

        output.write(String.format(Locale.US, "plot([%f %f],[0.0005 0.0005],'color','green','LineWidth', 1,'DisplayName', 'Effective width of sample: [x-2s,x+2s]')\n",
                this.ensembleStatistics.getMean() - 2*this.ensembleStatistics.getStandardDeviation(), this.ensembleStatistics.getMean() + 2*this.ensembleStatistics.getStandardDeviation()));

        output.write("hold off\nlegend\n");

        output.flush();
        output.close();
    }
}
