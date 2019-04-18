package statistics;

import nexteventsimulation.utility.API.Rvms;

import java.io.*;
import java.util.HashMap;

import java.util.Locale;
import java.util.Map;

public class BatchMeansManager {

    private Map<Integer, Batch> batchMap;
    private final double batchSize = 4096;
    private double numberOfSamples;

    private String metricName;
    private int currentBatchIndex;

    private double sampleSize;
    private double mean;
    private double standardDeviation;
    private double min;
    private double max;
    private double distanceFromMean;

    BatchMeansManager(String metricName) {

        this.metricName = metricName;
        this.currentBatchIndex = 0;
        this.numberOfSamples = 0;

        this.batchMap = new HashMap<Integer, Batch>();
        this.batchMap.put(currentBatchIndex, new Batch());
    }

    public void add(double data) {

        Batch currentBatch = batchMap.get(currentBatchIndex);

        if (currentBatch == null) {
            currentBatch = new Batch();
            batchMap.put(currentBatchIndex, currentBatch);
        }

        if (currentBatch.getBatchSize() != batchSize)
            currentBatch.add(data);
        else
            currentBatchIndex++;

        this.numberOfSamples++;
    }

    void computeStatistics() {

        Batch currentBatch;
        long index;
        double data;
        double sum = 0.0;
        double diff;

        index = 0;
        mean = 0.0;
        min = 0.0;
        max = 0.0;


        for (Map.Entry<Integer, Batch> pair : batchMap.entrySet()) {

            currentBatch = pair.getValue();
            if (currentBatch.getBatchSize() != batchSize)
                continue;

            data = currentBatch.getMean();
            index++;
            diff = data - mean;
            sum += diff * diff * (index - 1.0) / index;
            mean += diff / index;
            if (data > max)
                max = data;
            else if (data < min)
                min = data;

        }
        this.standardDeviation = Math.sqrt(sum / index);
        this.sampleSize = index;
    }

    void computeConfidenceInterval() {

        double confidenceLevel = 0.95;
        double alpha = 1 - confidenceLevel;

        Rvms rvms = new Rvms();
        long K = (long) (this.numberOfSamples / batchSize);
        double criticalValue = rvms.idfStudent(K - 1, 1 - 0.05 / 2);

        distanceFromMean = ((criticalValue * this.standardDeviation) / Math.sqrt(K - 1));
    }


    void writeStatisticsData() {

        String outputFileName = String.format("./output/%s", metricName);
        int replicationIndex = BatchMeansManagerRegister.getInstance().getCurrentReplicationIndex();

        try {

            File file = new File(outputFileName);
            FileWriter output;

            if (!file.exists()) {
                output = new FileWriter(outputFileName);
                output.write("grid on\nxlabel('Replication')\naxis([-1 10 0 20])\nhold on\n");
            } else
                output = new FileWriter(outputFileName, true);

            output.write(String.format(Locale.US, "plot(%d,%f,'r*')\nhold on\n", replicationIndex, mean));
            output.write(String.format(Locale.US, "plot([%d %d],[%f %f])\nhold on\n", replicationIndex, replicationIndex, mean - distanceFromMean, mean + distanceFromMean));

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
