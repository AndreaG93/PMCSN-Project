package outputanalysis.ensemblestatistics;

import nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry.LatexRegistry;
import nexteventsimulation.utility.SimulationRegistry;
import outputanalysis.Statistics;
import outputanalysis.scatterplots.ScatterPlotPoint;

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
            writeLatexTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeEnsembleOutputStatistic() throws IOException {

        FileWriter output = new FileWriter(String.format("%s/ensembleStatistics_%s", SimulationRegistry.getInstance().getOutputDirectoryName(), this.name));

        output.write(String.format(Locale.US, "Metric name: %s \n\n", this.name));

        for (int replicationNumber = 0; replicationNumber < this.values.size(); replicationNumber++)
            output.write(String.format(Locale.US, "Replication n. %d                   : %f \n", replicationNumber, this.values.get(replicationNumber)));

        output.write(String.format(Locale.US, "\nEnsemble average point estimate    : %f \n", this.ensembleStatistics.getMean()));
        output.write(String.format(Locale.US, "\nStandard error                     : %f \n", this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95)));
        output.write(String.format(Locale.US, "\nInterval                           : %f +- %f \n", this.ensembleStatistics.getMean(), this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95)));

        output.flush();
        output.close();
    }

    private void writeEnsembleOutputStatisticForMATLABGraphics() throws IOException {

        double analyticalValue = SimulationRegistry.getInstance().getAnalyticalValueRegistry().getAnalyticalValue(this.name);

        FileWriter output = new FileWriter(String.format("%s/ensembleStatistics_%s.m", SimulationRegistry.getInstance().getOutputDirectoryName(), this.name));

        double distanceFromMean = this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95);

        output.write("h=figure\n");

        // X
        output.write("x = [ ");
        for (double value : this.values) {
            output.write(String.format(Locale.US, " %f ", value));
        }
        output.write(" ];\n");

        // Y
        output.write("y = [ ");
        for (int i = 0; i < this.values.size(); i++) {
            output.write("0 ");
        }
        output.write(" ];\n");

        // Add scatter plot...

        output.write("hold on\nylim([-0.01 0.01])\n");
        output.write(String.format(Locale.US, "title('Avg = %f \\pm %f\\newline", this.ensembleStatistics.getMean(), distanceFromMean));
        output.write(String.format(Locale.US, "I_{95%s} = [%f, %f]          v_{Analytical value} = %f')\n", "%",
                this.ensembleStatistics.getMean() - distanceFromMean, this.ensembleStatistics.getMean() + distanceFromMean, analyticalValue));
        output.write("scatter(x,y,'filled','DisplayName','Transient statistic value.')\n");
        output.write(String.format(Locale.US, "xline(%f,'DisplayName','Analytical value')\n", analyticalValue));
        output.write(String.format(Locale.US, "xline(%f,'DisplayName','Computed mean value','color','blue','LineWidth', 1)\n", this.ensembleStatistics.getMean()));

        output.write(String.format(Locale.US, "plot([%f %f],[0 0],'color','red','LineWidth', 1,'DisplayName', 'Confidence interval 95%s.')\n",
                this.ensembleStatistics.getMean() - distanceFromMean, this.ensembleStatistics.getMean() + distanceFromMean, "%"));

        output.write(String.format(Locale.US, "plot([%f %f],[0.0005 0.0005],'color','green','LineWidth', 1,'DisplayName', 'Effective sample width: [x-2s,x+2s]')\n",
                this.ensembleStatistics.getMean() - 2 * this.ensembleStatistics.getStandardDeviation(), this.ensembleStatistics.getMean() + 2 * this.ensembleStatistics.getStandardDeviation()));

        output.write("set(gca,'YTickLabel',[])\n");
        output.write("hold off\nlegend('location','best')\n");
        output.write(String.format("saveas(h, '%s', 'png')\n", this.getClass().getSimpleName() + this.name));

        output.flush();
        output.close();
    }


    private void writeLatexTable() {

        double analyticalValue = SimulationRegistry.getInstance().getAnalyticalValueRegistry().getAnalyticalValue(this.name);
        double distanceFromMean = this.ensembleStatistics.getConfidenceIntervalDistanceFromMean(0.95);

        FileWriter output = null;
        try {
            output = new FileWriter(String.format("%s/latexTable.tex", SimulationRegistry.getInstance().getOutputDirectoryName()), true);

            output.write(String.format(Locale.US, "%s & $%f$ & $\\pm$ & $%f$ & $ [%f,%f] $ & %f \\\\\n  &&&&&\\\\\\hline\n", LatexRegistry.getInstance().getLatexSymbol(this.name), this.ensembleStatistics.getMean(),
                    distanceFromMean, this.ensembleStatistics.getMean() - distanceFromMean, this.ensembleStatistics.getMean() + distanceFromMean, analyticalValue));

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
