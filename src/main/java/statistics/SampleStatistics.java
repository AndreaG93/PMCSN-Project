package statistics;

import java.io.*;
import java.text.DecimalFormat;

public class SampleStatistics {

    private double sampleSize;
    private double mean;
    private double standardDeviation;
    private double min;
    private double max;

    public void calculateStatisticsFromFile(String filepath) throws IOException {

        long index;
        double data;
        double sum = 0.0;
        double diff;

        String line;
        FileReader fr = new FileReader(filepath);
        BufferedReader ReadThis = new BufferedReader(fr);
        index = 0;
        mean = 0.0;
        min = 0.0;
        max = 0.0;

        try {
            if ((line = ReadThis.readLine()) != null) {
                data = Double.parseDouble(line);
                index = 1;
                mean = data;
                min = data;
                max = data;
            }

            while ((line = ReadThis.readLine()) != null) {
                data = Double.parseDouble(line);
                index++;
                diff = data - mean;
                sum += diff * diff * (index - 1.0) / index;
                mean += diff / index;
                if (data > max)
                    max = data;
                else if (data < min)
                    min = data;
            }
        } catch (EOFException e) {
            System.out.println("SampleStatistics: " + e);
        } catch (NumberFormatException nfe) {
//      System.out.println("SampleStatistics: " + nfe);
        }

        this.standardDeviation = Math.sqrt(sum / index);
        this.sampleSize = index;
    }

    public void Print(){
        DecimalFormat f = new DecimalFormat("###0.000");

        System.out.println("\nfor a sample of size " + sampleSize);
        System.out.println("mean ................. =  " + f.format(mean));
        System.out.println("standard deviation ... =  " + f.format(standardDeviation));
        System.out.println("minimum .............. =  " + f.format(min));
        System.out.println("maximum .............. =  " + f.format(max));
    }

    public double getSampleSize() {
        return sampleSize;
    }

    public double getMean() {
        return mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}