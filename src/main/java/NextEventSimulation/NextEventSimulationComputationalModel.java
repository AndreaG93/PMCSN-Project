package NextEventSimulation;

import java.util.Map;

public interface NextEventSimulationComputationalModel {

    void initializeSystemStateVariables();

    void initializeSimulationClock();

    void ScheduleInitialEvent();

    boolean isEndingConditionReached();

    void advanceSimulationClockToNextScheduledEvent();

    void performNextScheduledEvent();

    void scheduleNextEvent();

    void updateStatistics();

    Map<String, Double> getSimulationResults();
}
