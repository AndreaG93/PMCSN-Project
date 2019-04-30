package nexteventsimulation.utility;

import nexteventsimulation.utility.API.Rngs;
import nexteventsimulation.utility.API.Rvgs;

public class RandomNumberGenerator {

    private static RandomNumberGenerator instance = null;
    private Rvgs rvgs;

    private RandomNumberGenerator() {
    }

    public double getExponential(int stream, double mean) {

        this.rvgs.rngs.selectStream(stream);
        return this.rvgs.exponential(mean);
    }

    public double getUniformBetween(long a, long b) {

        this.rvgs.rngs.selectStream(100);
        return this.rvgs.equilikely(a,b);
    }


    public static RandomNumberGenerator getInstance() {

        if (instance == null)
            instance = new RandomNumberGenerator();
        return instance;
    }

    public void initialize() {

        this.rvgs = new Rvgs(new Rngs());
        this.rvgs.rngs.plantSeeds(12345 * (SimulationRegistry.getInstance().getCurrentSimulationReplicationIndex()+1));
    }
}
