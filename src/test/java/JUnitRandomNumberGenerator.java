import nexteventsimulation.utility.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

public class JUnitRandomNumberGenerator {


    /**
     * In following test the threshold = 2
     */
    @Test
    public void randomNumberGeneratorTest() {

        final double AVERAGE_ARRIVAL_RATE_CLASS_1 = 4;
        final double AVERAGE_ARRIVAL_RATE_CLASS_2 = 6.25;

        final double CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_1 = 0.45;
        final double CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_2 = 0.27;
        final double CLOUD_AVERAGE_SERVICE_RATE_CLASS_1 = 0.25;
        final double CLOUD_AVERAGE_SERVICE_RATE_CLASS_2 = 0.22;

        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();

        double classOneArrivalTime_1 = randomNumberGenerator.getExponential(0, AVERAGE_ARRIVAL_RATE_CLASS_1 );  // 1.3000967376415709
        double classOneArrivalTime_2 = randomNumberGenerator.getExponential(0, AVERAGE_ARRIVAL_RATE_CLASS_1 );
        double classOneArrivalTime_3 = randomNumberGenerator.getExponential(0, AVERAGE_ARRIVAL_RATE_CLASS_1 );
        double classOneArrivalTime_4 = randomNumberGenerator.getExponential(0, AVERAGE_ARRIVAL_RATE_CLASS_1 );

        double classTwoArrivalTime_1 = randomNumberGenerator.getExponential(1, AVERAGE_ARRIVAL_RATE_CLASS_2 );  // 2.472173853510265
        double classTwoArrivalTime_2 = randomNumberGenerator.getExponential(1, AVERAGE_ARRIVAL_RATE_CLASS_2 );
        double classTwoArrivalTime_3 = randomNumberGenerator.getExponential(1, AVERAGE_ARRIVAL_RATE_CLASS_2 );
        double classTwoArrivalTime_4 = randomNumberGenerator.getExponential(1, AVERAGE_ARRIVAL_RATE_CLASS_2 );

        double classOneDepartureTimeCloudlet_1 = randomNumberGenerator.getExponential(3,  CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_1 ); // 0.28688769959837224
        double classOneDepartureTimeCloudlet_2 = randomNumberGenerator.getExponential(3,  CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_1 ); // 0.28688769959837224
        double classOneDepartureTimeCloudlet_3 = randomNumberGenerator.getExponential(3,  CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_1 ); // 0.28688769959837224
        double classOneDepartureTimeCloudlet_4 = randomNumberGenerator.getExponential(3,  CLOUDLET_AVERAGE_SERVICE_RATE_CLASS_1 ); // 0.28688769959837224









    }
}
