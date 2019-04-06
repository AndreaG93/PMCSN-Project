package nexteventsimulation.utility;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimulationEventList<SimulationEvent> extends PriorityQueue<SimulationEvent> {

    private static final Logger LOGGER = SimulationLogFactory.getLogger();

    public void schedule(SimulationEvent event){
        LOGGER.log(Level.INFO, "[SCHEDULING EVENT]: {0}", event);
        this.add(event);
    }
}
