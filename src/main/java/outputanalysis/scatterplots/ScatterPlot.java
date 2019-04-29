package outputanalysis.scatterplots;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

class ScatterPlot {

    private String name;
    private List<ScatterPlotPoint> values;
    private int discardedSamples = 0;

    ScatterPlot(String name) {
        this.values = new Vector<ScatterPlotPoint>();
        this.name = name;
    }

    void add(double x, double y) {

        if (this.discardedSamples == 300){
            this.values.add(new ScatterPlotPoint(x, y));
            this.discardedSamples = 0;
        }
        this.discardedSamples++;
    }

    void writeMATLABScatterPlot(int replicationIndex) {

        try {
            FileWriter output = new FileWriter(String.format("./output/ScatterPlot_%s.m", this.name), true);

            // X
            output.write(String.format("x%d = [ ", replicationIndex));
            for (ScatterPlotPoint point : this.values) {
                output.write(String.format(Locale.US, " %f ", point.getX()));
            }
            output.write(" ];\n");

            // Y
            output.write(String.format("y%d = [ ", replicationIndex));
            for (ScatterPlotPoint point : this.values) {
                output.write(String.format(Locale.US, " %f ", point.getY()));
            }
            output.write(" ];\n");

            // Add scatter plot...

            output.write(String.format("scatter(x%d,y%d,'.','DisplayName','Replication %d')\nhold on\n",
                    replicationIndex, replicationIndex, replicationIndex));

            output.flush();
            output.close();

        } catch (IOException e) {
            System.exit(-1);
        }
    }
}