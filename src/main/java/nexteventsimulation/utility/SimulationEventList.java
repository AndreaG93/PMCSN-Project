package nexteventsimulation.utility;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationEventList<SimulationEvent> extends PriorityQueue<SimulationEvent> {

    public void schedule(SimulationEvent event){
        this.add(event);
    }
}
