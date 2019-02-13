package NextEventSimulation;


import java.util.Iterator;
import java.util.Map;

public class NextEventSimulation {

    private NextEventSimulationComputationalModel nextEventSimulationComputationalModel;

    public NextEventSimulation(NextEventSimulationComputationalModel nextEventSimulationComputationalModel) {
        this.nextEventSimulationComputationalModel = nextEventSimulationComputationalModel;
    }

    public void execute() {

        initialize();

        while (nextEventSimulationComputationalModel.isEndingConditionReached()) {

            nextEventSimulationComputationalModel.advanceSimulationClockToNextScheduledEvent();
            nextEventSimulationComputationalModel.performNextScheduledEvent();
            nextEventSimulationComputationalModel.scheduleNextEvent();
            nextEventSimulationComputationalModel.updateStatistics();
        }

        Map<String, Double> results = nextEventSimulationComputationalModel.getSimulationResults();

        Iterator<Map.Entry<String, Double>> it = results.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Double> pair = it.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }

    }

    private void initialize() {

        nextEventSimulationComputationalModel.initializeSystemStateVariables();
        nextEventSimulationComputationalModel.initializeSimulationClock();
        nextEventSimulationComputationalModel.ScheduleInitialEvent();
    }
}