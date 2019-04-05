package nexteventsimulation.utility;

import nexteventsimulation.utility.API.Rngs;
import nexteventsimulation.utility.API.Rvgs;

public class RandomNumberGenerator {

    private static RandomNumberGenerator instance = null;

    private Rvgs rvgs;

    private RandomNumberGenerator() {
        this.rvgs = new Rvgs(new Rngs());
        this.rvgs.rngs.plantSeeds(12345);
    }

    public double getExponential(int stream, double rate) {

        this.rvgs.rngs.selectStream(stream);
        return this.rvgs.exponential(rate);
    }

    public static RandomNumberGenerator getInstance() {
        if (instance == null)
            instance = new RandomNumberGenerator();
        return instance;
    }
}
