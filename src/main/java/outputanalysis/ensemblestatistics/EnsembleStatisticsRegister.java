package outputanalysis.ensemblestatistics;

import java.util.HashMap;
import java.util.Map;

public class EnsembleStatisticsRegister {

    private static EnsembleStatisticsRegister instance = null;
    private Map<String, EnsembleStatistics> register;

    private EnsembleStatisticsRegister() {
        this.register = new HashMap<String, EnsembleStatistics>();
    }

    public static EnsembleStatisticsRegister getInstance() {
        if (instance == null)
            instance = new EnsembleStatisticsRegister();
        return instance;
    }

    public void addDataToEnsemble(String name, double value) {

        EnsembleStatistics output = register.get(name);

        if (output == null) {
            output = new EnsembleStatistics(name);
            register.put(name, output);
        }

        output.add(value);
    }

    public void computeStatisticsWritingOutputData() {

        for (Map.Entry<String, EnsembleStatistics> pair : register.entrySet())
            pair.getValue().computeEnsembleStatisticsWritingOutputData();
    }
}