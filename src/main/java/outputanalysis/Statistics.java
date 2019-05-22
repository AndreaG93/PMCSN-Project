package outputanalysis;

import nexteventsimulation.utility.API.Rvms;

import java.util.List;

public class Statistics {

    List<Double> randomValuesList;
    double mean;
    double standardDeviation;

    public Statistics(List<Double> randomValuesList) {
        this.randomValuesList = randomValuesList;

        computeMeanAndStandardDeviation();
    }

    private void computeMeanAndStandardDeviation() {

        int n = 0;
        double sum = 0.0;
        double diff;
        this.mean = 0.0;

        // Welford’s Algorithm
        for (double value : this.randomValuesList) {
            n++;
            diff = value - this.mean;
            sum += Math.pow(diff, 2) * ((n - 1.0) / n);
            this.mean += diff / n;
        }

        this.standardDeviation = Math.sqrt(sum / n);
    }

    public double getMean() {
        return mean;
    }

    public double getConfidenceIntervalDistanceFromMean(double confidenceIntervalLevel) {

        // Algorithm 8.1.1 - pag 354
        double alpha = 1 - confidenceIntervalLevel;
        long randomSampleSize = this.randomValuesList.size();

        Rvms rvms = new Rvms();
        double criticalValue = rvms.idfStudent(randomSampleSize - 1, 1 - alpha / 2);

        return ((criticalValue * this.standardDeviation) / Math.sqrt(randomSampleSize - 1));
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }
}

