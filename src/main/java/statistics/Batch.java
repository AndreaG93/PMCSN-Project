package statistics;

public class Batch {

    private int index;
    private double mean;

    Batch() {
        this.index = 0;
        this.mean = 0;
    }

    void add(double data) {
        index++;
        mean += ((data - mean) / index);
    }

    public double getMean() {
        return mean;
    }

    double getBatchSize() {
        return index;
    }
}
