package outputanalysis.batchmeans;

import nexteventsimulation.utility.SimulationRegistry;

import java.util.HashMap;
import java.util.Map;

public class BatchMeansRegister {

    private static BatchMeansRegister instance = null;
    private Map<String, BatchMeans> register;


    private BatchMeansRegister() {
    }

    public static BatchMeansRegister getInstance() {
        if (instance == null)
            instance = new BatchMeansRegister();
        return instance;
    }

    public void addDataToBatch(String name, double value) {

        BatchMeans output = register.get(name);

        if (output == null) {
            output = new BatchMeans(name);
            register.put(name, output);
        }

        output.add(value);
    }

    public void computeStatisticsAndWriteData() {

        for (Map.Entry<String, BatchMeans> pair : register.entrySet())
            pair.getValue().writeOutputStatisticForMATLABGraphics(SimulationRegistry.getInstance().getCurrentSimulationReplicationIndex());

    }


    public void initialize() {
        this.register = new HashMap<String, BatchMeans>();
    }
}