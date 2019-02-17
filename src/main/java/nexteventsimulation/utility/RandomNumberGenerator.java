package nexteventsimulation.utility;

import nexteventsimulation.utility.API.Rngs;
import nexteventsimulation.utility.API.Rvgs;

public class RandomNumberGenerator {

    private Rvgs rvgs;

    public RandomNumberGenerator(){
        this.rvgs = new Rvgs(new Rngs());
        this.rvgs.rngs.plantSeeds(12345);
    }

    public double getExponential(int stream, double rate) {

        this.rvgs.rngs.selectStream(stream);
        return this.rvgs.exponential(rate);
    }
}
