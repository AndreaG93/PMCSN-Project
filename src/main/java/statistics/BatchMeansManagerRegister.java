package statistics;

import java.util.HashMap;
import java.util.Map;

public class BatchMeansManagerRegister {

    private static BatchMeansManagerRegister instance = null;

    private Map<String, BatchMeansManager> batchMeansManagerMap;

    private BatchMeansManagerRegister(){
        batchMeansManagerMap = new HashMap<String, BatchMeansManager>();
    }

    public static BatchMeansManagerRegister getInstance() {
        if (instance == null)
            instance = new BatchMeansManagerRegister();
        return instance;
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
}
