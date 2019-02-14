import next_event_simulation.NextEventSimulationOrchestrator;

public class EntryPoint {

    public static void main(String args[]) {

        SingleServerServiceNode ComputationalModel = new SingleServerServiceNode();
        NextEventSimulationOrchestrator simulationOrchestrator = new NextEventSimulationOrchestrator(ComputationalModel);

        simulationOrchestrator.executeSimulation();
    }
}

