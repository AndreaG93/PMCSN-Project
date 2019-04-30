package outputanalysis.histograms;





import nexteventsimulation.utility.SimulationRegistry;

import java.util.HashMap;
import java.util.Map;

public class HistogramsRegister {

    private static HistogramsRegister instance = null;
    private Map<String, Histograms> register;

    private HistogramsRegister() {
        this.register = new HashMap<String, Histograms>();
    }

    public static HistogramsRegister getInstance() {
        if (instance == null)
            instance = new HistogramsRegister();
        return instance;
    }


    public void addData(String name, double value){

        Histograms output = register.get(name);

        if (output == null){
            output = new Histograms(name);
            register.put(name, output);
        }

        output.add(value);
    }

    public void computeStatisticsAndWriteData(){

        for (Map.Entry<String, Histograms> pair : register.entrySet())
            pair.getValue().writeMATLABScriptPlot(SimulationRegistry.getInstance().getCurrentSimulationReplicationIndex());

    }

    public void initialize() {
        this.register = new HashMap<String, Histograms>();
    }
}
