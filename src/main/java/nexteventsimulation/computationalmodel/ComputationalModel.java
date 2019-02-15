package nexteventsimulation.computationalmodel;

import nexteventsimulation.NextEventSimulation;
import nexteventsimulation.utility.SimulatedEvent;
import nexteventsimulation.utility.SimulatedClock;
import nexteventsimulation.utility.RandomNumberGenerator;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class ComputationalModel implements NextEventSimulation {

    protected PriorityQueue<SimulatedEvent> eventList = new PriorityQueue<SimulatedEvent>();
    protected SimulatedClock simulationClock = new SimulatedClock();
    protected RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    protected abstract void initializeSystemStateVariables();

    protected abstract void initializeSimulationClock();

    protected abstract void scheduleInitialEvent();

    protected abstract void updateStatistics();

    protected abstract Map<String, Double> getSimulationResults();

    @Override
    public void perform() {

        initializeSimulation();

        while (!isSimulationFinalStateReached()){

            SimulatedEvent actualEvent = this.eventList.poll();

            if (actualEvent != null) {

                advanceSimulationClockTo(actualEvent.getTime());
                actualEvent.perform();
                actualEvent.scheduleFollowingEvent();

                SimulatedEvent nextEvent = this.eventList.peek();

                if (nextEvent != null)
                    this.advanceSimulationNextEventClockTo(nextEvent.getTime());


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

    private void advanceSimulationClockTo(double time){
        this.simulationClock.setTime(time);
    }

    private void advanceSimulationNextEventClockTo(double time){
        this.simulationClock.setNextEventTime(time);
    }

    private void printSimulationResults(){

        Map<String, Double> results = getSimulationResults();

        Iterator<Map.Entry<String, Double>> it = results.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Double> pair = it.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }


    public SimulatedClock getSimulationClock() {
        return simulationClock;
    }

    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }
}