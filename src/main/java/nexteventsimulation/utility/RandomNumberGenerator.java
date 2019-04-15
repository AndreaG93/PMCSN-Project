package nexteventsimulation.utility;

import nexteventsimulation.utility.API.Rngs;
import nexteventsimulation.utility.API.Rvgs;

public class RandomNumberGenerator {

    private static RandomNumberGenerator instance = null;
    private Rvgs rvgs;
    private int replicationIndex;

    private RandomNumberGenerator() {
        this.rvgs = new Rvgs(new Rngs());
        this.rvgs.rngs.plantSeeds(123456789);
    }

    public double getExponential(int stream, double mean) {

        this.rvgs.rngs.selectStream(replicationIndex + stream);
        return this.rvgs.exponential(mean);
    }

    public static RandomNumberGenerator getInstance() {
        if (instance == null)
            instance = new RandomNumberGenerator();
        return instance;
    }

    public void setReplicationIndex(int replicationIndex) {
        this.replicationIndex = replicationIndex;
    }
}
