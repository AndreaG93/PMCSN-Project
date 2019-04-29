package outputanalysis.batchmeans;

import java.util.HashMap;
import java.util.Map;

public class BatchMeansRegister {

    private static BatchMeansRegister instance = null;
    private Map<String, BatchMeans> register;
    private int replicationIndex;

    private BatchMeansRegister() {}

    public static BatchMeansRegister getInstance() {
        if (instance == null)
            instance = new BatchMeansRegister();
        return instance;
    }


    public void addDataToBatch(String name, double value){

        BatchMeans output = register.get(name);

        if (output == null){
            output = new BatchMeans(name);
            register.put(name, output);
        }

        output.add(value);
    }

    public void computeStatisticsAndWriteData(){

        for (Map.Entry<String, BatchMeans> pair : register.entrySet())
            pair.getValue().writeOutputStatisticForMATLABGraphics(this.replicationIndex);

    }

    public void setReplicationIndex(int replicationIndex) {
        this.replicationIndex = replicationIndex;
        this.register = new HashMap<String, BatchMeans>();
    }
}