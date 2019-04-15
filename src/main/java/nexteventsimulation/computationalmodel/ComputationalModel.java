package nexteventsimulation.computationalmodel;

import nexteventsimulation.NextEventSimulation;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationEvent;
import nexteventsimulation.utility.SimulationEventList;
import statistics.BatchMeansManagerRegister;
import java.util.Map;

public abstract class ComputationalModel implements NextEventSimulation {

    protected SimulationEventList<SimulationEvent> simulationEventList = new SimulationEventList<SimulationEvent>();

    protected abstract void initializeSystemStateVariables();

    protected abstract void initializeSimulationClock();

    protected abstract void scheduleInitialEvent();

    protected abstract void updateStatistics();

    protected abstract Map<String, Double> getSimulationResults();

    @Override
    public void perform() {

        initializeSimulation();

        while (!this.simulationEventList.isEmpty()) {

            SimulationEvent actualEvent = this.simulationEventList.poll();

            if (actualEvent != null) {

                SimulationClock.getInstance().setCurrentEventTime(actualEvent.getStartTime());

                actualEvent.perform();
                actualEvent.scheduleFollowingEvent();

                SimulationEvent nextEvent = this.simulationEventList.peek();

                if (nextEvent != null)
                    SimulationClock.getInstance().setNextEventTime(nextEvent.getStartTime());
            }
            updateStatistics();
        }

        produceStatisticResultsThroughBatchMeansMethod();

        printSimulationResults();
    }

    private void produceStatisticResultsThroughBatchMeansMethod(){
        BatchMeansManagerRegister.getInstance().computeStatisticsAndWriteData();
    }

    private void initializeSimulation() {
        initializeSystemStateVariables();
        initializeSimulationClock();
        scheduleInitialEvent();
    }

    private void printSimulationResults() {

        Map<String, Double> results = getSimulationResults();

        for (Map.Entry<String, Double> pair : results.entrySet()) {
            java.lang.System.out.println(pair.getKey());
            java.lang.System.out.println(pair.getValue());
        }
    }
}