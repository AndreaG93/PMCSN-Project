package nexteventsimulation.utility;

import java.util.Map;

public abstract class SimulationAnalyticValueRegistry {

    protected Map<String, Double> register;

    protected SimulationAnalyticValueRegistry() {
        loadDataIntoRegistry();
    }

    protected abstract void loadDataIntoRegistry();

    public double getAnalyticalValue(String name) {

        Double output = register.get(name);

        if (output == null)
            return -1;

        return output;
    }
}
