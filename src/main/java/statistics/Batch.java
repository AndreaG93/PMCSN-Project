package statistics;

public class Batch {

    private int index = 0;
    private double mean = 0;
    private double sum = 0.0;
    private double min;
    private double max;

    public void add(double data) {

        if (index == 0) {

            index = 1;
            mean = data;
            min = data;
            max = data;
        }

        index++;
        double diff = data - mean;
        sum += diff * diff * (index - 1.0) / index;
        mean += diff / index;
        if (data > max)
            max = data;
        else if (data < min)
            min = data;
    }

    public double getMean() {
        return mean;
    }

    public double getNumberOfSample(){
        return index;
    }
}
