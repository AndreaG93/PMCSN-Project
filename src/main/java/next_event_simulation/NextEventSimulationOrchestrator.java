package next_event_simulation;

import java.util.Iterator;
import java.util.Map;

/**
 *
 */
public class NextEventSimulationOrchestrator {

    private NextEventSimulationComputationalModel simulationModel;

    public NextEventSimulationOrchestrator(NextEventSimulationComputationalModel simulationModel) {
        this.simulationModel = simulationModel;
    }

    public void executeSimulation() {

        simulationModel.initialize();
       

        while (!simulationModel.isEndingConditionReached()) {

            simulationModel.advanceSimulationClock();
            simulationModel.performScheduledEvent();
            simulationModel.scheduleNextEvent();
            simulationModel.updateStatistics();
            
            
        }

        printSimulationResults();

    }

    private void printSimulationResults(){

        Map<String, Double> results = simulationModel.getSimulationResults();

        Iterator<Map.Entry<String, Double>> it = results.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Double> pair = it.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }
}