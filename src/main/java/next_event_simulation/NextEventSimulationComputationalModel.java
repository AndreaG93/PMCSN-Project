package next_event_simulation;

import next_event_simulation.utils.RandomVariatesGenerator;

import java.util.Map;
import java.util.PriorityQueue;

public abstract class NextEventSimulationComputationalModel {

    protected PriorityQueue<Event> eventList = new PriorityQueue<Event>();
    protected NextEventSimulationClock nextEventSimulationClock = new NextEventSimulationClock();
    protected RandomVariatesGenerator randomVariatesGenerator = new RandomVariatesGenerator();

    public abstract void initializeSystemStateVariables();

    public abstract void initializeSimulationClock();

    public abstract void ScheduleInitialEvent();

    public abstract void updateStatistics();

    public abstract Map<String, Double> getSimulationResults();

    void initialize() {
        initializeSystemStateVariables();
        initializeSimulationClock();
        ScheduleInitialEvent();
    }

    void advanceSimulationClock() {

        Event nextEvent = this.eventList.peek();

        if (nextEvent != null) {
            nextEventSimulationClock.setCurrentTime(nextEvent.getScheduledTime());
        }
    }

    void performScheduledEvent() {

        Event nextEvent = this.eventList.peek();

        if (nextEvent != null)
            nextEvent.perform();
    }

    void scheduleNextEvent() {

        Event currentEvent = this.eventList.poll();

        if (currentEvent != null)
            currentEvent.scheduleNextRelatedEvent();

        Event nextEvent = this.eventList.peek();
        if (nextEvent != null)
            this.nextEventSimulationClock.setNextEventTime(nextEvent.getScheduledTime());

    }

    boolean isEndingConditionReached() {
        return this.eventList.isEmpty();
    }
}