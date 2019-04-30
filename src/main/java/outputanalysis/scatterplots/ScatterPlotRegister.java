package outputanalysis.scatterplots;

import nexteventsimulation.utility.SimulationRegistry;

import java.util.HashMap;
import java.util.Map;

public class ScatterPlotRegister {

    private static ScatterPlotRegister instance = null;
    private Map<String, ScatterPlot> register;

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
            pair.getValue().writeMATLABScatterPlot(SimulationRegistry.getInstance().getCurrentSimulationReplicationIndex());
    }

    public void initialize() {
        this.register = new HashMap<String, ScatterPlot>();
    }
}
