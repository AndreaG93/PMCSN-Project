/*
import nexteventsimulation.utility.API.Rvms;
import nexteventsimulation.utility.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class WriteOnFile {


    public void test11() {


        String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
        try {

            RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();

            int totalSamples = 0;
            for (int n = 0; totalSamples < 10000; n++) {

                String outputFileName = String.format("D:\\File\\expreriment\\file%d", n);
                FileWriter outputFile = new FileWriter(outputFileName);

                for (int x = 0; x < 9; x++) {
                    String outputData = String.valueOf(randomNumberGenerator.getExponential(0, 3));
                    outputFile.write(outputData + "\n");
                    totalSamples++;
                }

                outputFile.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ExtractMeanFromSampleStatisticsList(List<Statistic> list) {
        try {
            FileWriter outputFile = new FileWriter("D:\\File\\expreriment\\output");

            for (Statistic obj : list) {
                outputFile.write(obj.getMean() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void ProduceAvg() {

        Vector<Statistic> sampleStatisticsVector = new Vector<Statistic>();

        File directory = new File("D:\\File\\expreriment");
        File[] fileList = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("file");
            }
        });

        for (File file : fileList) {

            Statistic obj = new Statistic();
            try {
                obj.calculateStatisticsFromFile(file.getAbsolutePath());
            } catch (IOException e) {
                System.exit(1);
            }
            sampleStatisticsVector.add(obj);
        }

        ExtractMeanFromSampleStatisticsList(sampleStatisticsVector);
    }

    @Test
    public void intervalConfidenceOfSample(){

        double confidenceLevel = 0.95;
        double alpha = 1 - confidenceLevel;
        double sampleSize = 9;

        Statistic obj = new Statistic();
        try {
            obj.calculateStatisticsFromFile("D:\\File\\expreriment\\file0");
            obj.Print();
        } catch (IOException e) {
            System.exit(1);
        }

        Rvms rvms = new Rvms();
        double criticalValue = rvms.idfStudent(9, 1-alpha/2);
        System.out.println(criticalValue);

        double distanceFromMean = (criticalValue*obj.getStandardDeviation())/Math.sqrt(obj.getSampleSize()-1);
        double criticalEndPointUp =  obj.getMean() + distanceFromMean;
        double criticalEndPointDown =  obj.getMean() - distanceFromMean;


        System.out.println(criticalEndPointUp);
        System.out.println(criticalEndPointDown);

        System.out.println(String.format("Interval %.2f +- %.2f", obj.getMean(), distanceFromMean));
    }
}
*/