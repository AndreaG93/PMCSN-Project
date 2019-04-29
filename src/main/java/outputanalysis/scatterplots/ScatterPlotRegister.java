package outputanalysis.scatterplots;

import java.util.HashMap;
import java.util.Map;

public class ScatterPlotRegister {

    private static ScatterPlotRegister instance = null;
    private Map<String, ScatterPlot> register;
    private int replicationIndex;

    private ScatterPlotRegister() {
        this.register = new HashMap<String, ScatterPlot>();
    }

    public static ScatterPlotRegister getInstance() {
        if (instance == null)
            instance = new ScatterPlotRegister();
        return instance;
    }

    public void addData(String name, double x, double y) {

        ScatterPlot output = register.get(name);

        if (output == null) {
            output = new ScatterPlot(name);
            register.put(name, output);
        }

        output.add(x,y);
    }

    public void writingOutputData() {

        for (Map.Entry<String, ScatterPlot> pair : register.entrySet())
            pair.getValue().writeMATLABScatterPlot(replicationIndex);
    }

    public void setReplicationIndex(int replicationIndex) {
        this.replicationIndex = replicationIndex;
        this.register = new HashMap<String, ScatterPlot>();
    }
}
