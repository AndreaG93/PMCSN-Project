package statistics;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class BatchMeansManagerRegister {

    private static BatchMeansManagerRegister instance = null;

    private int replicationIndex;

    private Map<String, BatchMeansManager> batchMeansManagerMap;

    private BatchMeansManagerRegister(){

        File outputDir = new File("./output");
        FileWriter output;

        if (!outputDir.exists()) {
            outputDir.mkdir();
        }
    }

    public static BatchMeansManagerRegister getInstance() {
        if (instance == null)
            instance = new BatchMeansManagerRegister();
        return instance;
    }

    public int getCurrentReplicationIndex() {
        return replicationIndex;
    }

    public BatchMeansManager getBatchMeansManager(String statisticMetricName){

        BatchMeansManager output = batchMeansManagerMap.get(statisticMetricName);

        if (output == null){
            output = new BatchMeansManager(statisticMetricName);
            batchMeansManagerMap.put(statisticMetricName, output);
        }

        return output;
    }

    public void computeStatisticsAndWriteData(){

        for (Map.Entry<String, BatchMeansManager> pair : batchMeansManagerMap.entrySet()) {

            pair.getValue().computeStatistics();
            pair.getValue().computeConfidenceInterval();
            pair.getValue().writeStatisticsData();
        }
    }

    public void setReplicationIndex(int currentReplicationIndex) {
        this.replicationIndex = currentReplicationIndex;

        batchMeansManagerMap = new HashMap<String, BatchMeansManager>();
    }
}
