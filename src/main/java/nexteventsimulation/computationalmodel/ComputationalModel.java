package nexteventsimulation.computationalmodel;

import nexteventsimulation.NextEventSimulation;
import nexteventsimulation.utility.SimulationClock;
import nexteventsimulation.utility.SimulationEvent;
import nexteventsimulation.utility.SimulationEventList;
import outputanalysis.batchmeans.BatchMeansRegister;
import outputanalysis.ensemblestatistics.EnsembleStatisticsRegister;
import outputanalysis.histograms.HistogramsRegister;
import outputanalysis.scatterplots.ScatterPlotRegister;

import java.util.Map;

public abstract class ComputationalModel implements NextEventSimulation {

    protected SimulationEventList<SimulationEvent> simulationEventList = new SimulationEventList<>();

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

        BatchMeansRegister.getInstance().computeStatisticsAndWriteData();
        ScatterPlotRegister.getInstance().writingOutputData();
        HistogramsRegister.getInstance().computeStatisticsAndWriteData();

        EnsembleStatisticsRegister ensembleStatisticsRegister = EnsembleStatisticsRegister.getInstance();

        for (Map.Entry<String, Double> pair : getSimulationResults().entrySet())
            ensembleStatisticsRegister.addDataToEnsemble(pair.getKey(), pair.getValue());
    }

    private void initializeSimulation() {
        initializeSystemStateVariables();
        initializeSimulationClock();
        scheduleInitialEvent();
    }
}