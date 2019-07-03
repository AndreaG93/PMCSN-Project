package nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry;

import nexteventsimulation.utility.SimulationRegistry;

import java.util.HashMap;
import java.util.Map;

public class LatexRegistry {

    private static LatexRegistry instance = null;
    private Map<String, String> register;

    private LatexRegistry() {
        loadDataIntoRegistry();
    }

    public static LatexRegistry getInstance() {
        if (instance == null)
            instance = new LatexRegistry();
        return instance;
    }

    public String getLatexSymbol(String name) {

        String output = register.get(name);

        if (output == null)
            return "";

        return output;
    }


    private void loadDataIntoRegistry() {

        this.register = new HashMap<>();

        // Cloudlet Time-Average Population

        this.register.put("Cloudlet_Class1JobsNumber", "$E[N_{cloudlet}^{(1)}]$");
        this.register.put("Cloudlet_Class2JobsNumber", "$E[N_{cloudlet}^{(2)}]$");
        this.register.put("Cloudlet_JobsNumber", "$E[N_{cloudlet}]$");

        // Cloud Time-Average Population

        this.register.put("Cloud_Class1JobsNumber", "$E[N_{cloud}^{(1)}]$");
        this.register.put("Cloud_Class2JobsNumber", "$E[N_{cloud}^{(2)}]$");
        this.register.put("Cloud_JobsNumber", "$E[N_{cloud}]$");

        // GlobalNetwork Time-Average Population

        this.register.put("GlobalNetwork_Class1JobsNumber", "$E[N^{(1)}]$");
        this.register.put("GlobalNetwork_Class2JobsNumber", "$E[N^{(2)}]$");
        this.register.put("GlobalNetwork_JobsNumber", "$E[N]$");

        // ***************************************************************** //

        // Cloudlet Time-Average Service Time

        this.register.put("Cloudlet_Class1JobsServiceTime", "$E[S_{cloudlet}^{(1)}]$");
        this.register.put("Cloudlet_Class2JobsServiceTime", "$E[S_{cloudlet}^{(2)}]$");
        this.register.put("Cloudlet_JobsServiceTime", "$E[S_{cloudlet}]$");

        // Cloud Time-Average Service Time

        this.register.put("Cloud_Class1JobsServiceTime", "$E[S_{cloud}^{(1)}]$");
        this.register.put("Cloud_Class2JobsServiceTime", "$E[S_{cloud}^{(2)}]$");
        this.register.put("Cloud_JobsServiceTime", "$E[S_{cloud}]$");

        // GlobalNetwork Time-Average Service Time

        this.register.put("GlobalNetwork_Class1JobsServiceTime", "$E[S^{1}]$");
        this.register.put("GlobalNetwork_Class2JobsServiceTime", "$E[S^{2}]$");
        this.register.put("GlobalNetwork_JobsServiceTime", "$E[S]$");

        // ***************************************************************** //

        // Cloudlet Throughput

        this.register.put("Cloudlet_Class1Throughput", "$X_{cloudlet}^{(1)}$");
        this.register.put("Cloudlet_Class2Throughput", "$X_{cloudlet}^{(2)}$");
        this.register.put("Cloudlet_Throughput", "$X_{cloudlet}$");

        // Cloud Throughput

        this.register.put("Cloud_Class1Throughput", "$X_{cloud}^{(1)}$");
        this.register.put("Cloud_Class2Throughput", "$X_{cloud}^{(2)}$");
        this.register.put("Cloud_Throughput", "$X_{cloud}$");

        // GlobalNetwork Throughput

        this.register.put("GlobalNetwork_Class1Throughput", "$X^{(1)}$");
        this.register.put("GlobalNetwork_Class2Throughput", "$X^{(2)}$");
        this.register.put("GlobalNetwork_Throughput", "$X$");
    }
}
