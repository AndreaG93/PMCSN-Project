package outputanalysis.histograms;

import outputanalysis.Statistics;
import outputanalysis.scatterplots.ScatterPlotPoint;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class Histograms {

    private String name;
    private List<Double> values;
    private static double MIN = 0.0;
    private static double MAX = 100.0;
    private static int K = 500;                             /* number of histogram bins   */
    private static double DELTA = ((MAX - MIN) / K);        /* histogram bin size (width) */

    Histograms(String name) {

        this.values = new Vector<Double>();
        this.name = name;
    }

    public void add(double value) {
        this.values.add(value);
    }

    void writeMATLABScriptPlot(int replicationIndex) {

        int j;                                      /* histogram bin index */
        long count[] = new long[K];                 /* bin count           */
        double midpoint[] = new double[K];          /* bin midpoint        */

        Statistics statistics = new Statistics(this.values);
        double mean = statistics.getMean();
        double standardDeviation = statistics.getStandardDeviation();

        for (j = 0; j < K; j++) {
            count[j] = 0;
            midpoint[j] = MIN + (j + 0.5) * DELTA;
        }

        for (Double x : this.values) {

            if ((x >= MIN) && (x < MAX)) {
                j = (int) ((x - MIN) / DELTA);
                count[j]++;
            }
        }

        try {

            FileWriter output = new FileWriter(String.format("./output/Histogram_%s_%d.m", this.name, replicationIndex));

            for (j = 0; j < K; j++)
                output.write(String.format(Locale.US, "\nx%d = %f.* ones(%d,1);\n", (j + 1), midpoint[j], count[j]));

            output.write("hold on\n%xline(0,'DisplayName','Analytical value')\n");

            output.write(String.format(Locale.US, "plot([%f %f],[-3 -3],'color','green','LineWidth', 5,'DisplayName', '95.45%s of values are within 2 standard deviations')\n",
                    mean - 2 * standardDeviation, mean + 2 * standardDeviation, "%"));

            output.write("histogram([");
            for (j = 0; j < K - 1; j++)
                output.write(String.format(Locale.US, "x%d;", (j + 1)));
            output.write(String.format(Locale.US, "x%d],%d,'HandleVisibility','off')\n", K, K));

            output.write("legend");

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
