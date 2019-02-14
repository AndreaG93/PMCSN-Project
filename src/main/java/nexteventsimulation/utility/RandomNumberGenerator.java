package nexteventsimulation.utility;

import nexteventsimulation.utility.API.Rngs;
import nexteventsimulation.utility.API.Rvgs;

public class RandomNumberGenerator {

    private Rvgs rvgs;

    public RandomNumberGenerator(){
        this.rvgs = new Rvgs(new Rngs());
        this.rvgs.rngs.plantSeeds(0);
    }

    public double getExponentialInterArrivalTime() {

        this.rvgs.rngs.selectStream(0);
        return this.rvgs.exponential(2.0);
    }

    public double getErlangDistributedServiceTime() {

        this.rvgs.rngs.selectStream(1);
        return this.rvgs.erlang(5, 0.3);
    }
}
