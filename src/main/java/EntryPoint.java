import nexteventsimulation.NextEventSimulation;
import nexteventsimulation.NextEventSimulationFactory;

public class EntryPoint {

    public static void main(String args[]) {

        NextEventSimulation singleServerSimulation = NextEventSimulationFactory.built("SingleServer");

        if (singleServerSimulation != null)
            singleServerSimulation.perform();
    }
}

