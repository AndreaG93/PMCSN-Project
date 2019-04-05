package nexteventsimulation.computationalmodel;

import nexteventsimulation.NextEventSimulation;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationEvent;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class ComputationalModel implements NextEventSimulation {

    protected PriorityQueue<SimulationEvent> eventList;

    protected abstract void initializeSystemStateVariables();

    protected abstract void initializeSimulationClock();

    protected abstract void scheduleInitialEvent();

    protected abstract void updateStatistics();

    protected abstract Map<String, Double> getSimulationResults();

    @Override
    public void perform() {

        initializeSimulation();

        while (!isSimulationFinalStateReached()) {

            SimulationEvent actualEvent = this.eventList.poll();

            if (actualEvent != null) {

                SimulationClock.getInstance().setCurrentEventTime(actualEvent.getStartTime());

                actualEvent.perform();
                actualEvent.scheduleFollowingEvent();

                SimulationEvent nextEvent = this.eventList.peek();

                if (nextEvent != null)
                    SimulationClock.getInstance().setNextEventTime(nextEvent.getStartTime());
            }
            updateStatistics();
        }
        printSimulationResults();
    }

    private void initializeSimulation() {
        initializeSystemStateVariables();
        initializeSimulationClock();
        scheduleInitialEvent();
    }

    private boolean isSimulationFinalStateReached() {
        return this.eventList.isEmpty();
    }

    private void printSimulationResults() {

        Map<String, Double> results = getSimulationResults();

        Iterator<Map.Entry<String, Double>> it = results.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Double> pair = it.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }
}