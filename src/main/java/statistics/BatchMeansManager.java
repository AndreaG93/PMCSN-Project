package statistics;

import nexteventsimulation.utility.API.Rvms;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;

import java.util.Map;

public class BatchMeansManager {

    private Map<Integer, Batch> batchMap;
    private final int batchSize = 10000;
    private int numberOfBatch;

    private String metricName;
    private int currentBatchIndex;
    private int currentProcessedElementIndex;

    private int N;

    private double sampleSize;
    private double mean;
    private double standardDeviation;
    private double min;
    private double max;
    private double distanceFromMean;

    public BatchMeansManager(String metricName) {

        this.metricName = metricName;
        currentBatchIndex = 0;
        currentProcessedElementIndex = 0;

        batchMap = new HashMap<Integer, Batch>();
        batchMap.put(currentBatchIndex, new Batch());
    }

    public void add(double data) {

        N++;

        if (currentProcessedElementIndex == batchSize) {

            currentBatchIndex++;
            currentProcessedElementIndex = 0;

            batchMap.put(currentBatchIndex, new Batch());
        }

        Batch currentBatch = batchMap.get(currentBatchIndex);
        currentBatch.add(data);
        currentProcessedElementIndex++;
    }

    public void computeStatistics() {

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
            if (currentBatch.getNumberOfSample() != batchSize + 1)
                break;

            if (index == 0) {

                data = currentBatch.getMean();
                index = 1;
                mean = data;
                min = data;
                max = data;

            } else {
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
        }
        this.standardDeviation = Math.sqrt(sum / index);
        this.sampleSize = index;
    }

    public void computeConfidenceInterval() {

        double confidenceLevel = 0.95;
        double alpha = 1 - confidenceLevel;

        Rvms rvms = new Rvms();
        long K = N / batchSize;
        double criticalValue = rvms.idfStudent(K, 1 - alpha / 2);

        distanceFromMean = (criticalValue * this.standardDeviation / Math.sqrt(K - 1));
    }


    public void writeStatisticsData() {

        File outputDir = new File("./data");
        FileWriter output;

        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        try {
            output = new FileWriter(String.format("./data/%s%d", metricName,  BatchMeansManagerRegister.getInstance().getCurrentReplicationIndex()));


            output.write(String.format("Metric Name %s\n\n", metricName));

            output.write(String.format("Sample Size %f\n", sampleSize));
            output.write(String.format("Mean %f\n", mean));
            output.write(String.format("Standard Deviation %f\n", standardDeviation));
            output.write(String.format("Minimum %f\n", min));
            output.write(String.format("Maximum %f\n", max));
            output.write(String.format("Interval %f +- %f (%f,%f)", mean, distanceFromMean, mean-distanceFromMean, mean+distanceFromMean));

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
