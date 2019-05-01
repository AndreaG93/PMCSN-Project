package nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry;

import nexteventsimulation.utility.SimulationAnalyticValueRegistry;

import java.util.HashMap;

public class SimulationAnalyticValueRegistryAlgorithm1 extends SimulationAnalyticValueRegistry {

    @Override
    protected void loadDataIntoRegistry() {

        this.register = new HashMap<String, Double>();

        // Cloudlet Time-Average Population

        this.register.put("Cloudlet_Class1JobsNumber", 5.204009618);
        this.register.put("Cloudlet_Class2JobsNumber", 13.55210838);
        this.register.put("Cloudlet_JobsNumber", 18.75611799);

        // Cloud Time-Average Population

        this.register.put("Cloud_Class1JobsNumber", 6.622806284);
        this.register.put("Cloud_Class2JobsNumber", 11.759244113);
        this.register.put("Cloud_JobsNumber", 18.382050397);

        // GlobalNetwork Time-Average Population

        this.register.put("GlobalNetwork_Class1JobsNumber", 11.826815902);
        this.register.put("GlobalNetwork_Class2JobsNumber", 25.311352493);
        this.register.put("GlobalNetwork_JobsNumber", 37.138168396);

        // ***************************************************************** //

        // Cloudlet Time-Average Service Time

        this.register.put("Cloudlet_Class1JobsServiceTime", 2.222222222);
        this.register.put("Cloudlet_Class2JobsServiceTime", 3.703770377);
        this.register.put("Cloudlet_JobsServiceTime", 3.125564588);

        // Cloud Time-Average Service Time

        this.register.put("Cloud_Class1JobsServiceTime", 4.0);
        this.register.put("Cloud_Class2JobsServiceTime", 4.545454545);
        this.register.put("Cloud_JobsServiceTime", 4.332594235);

        // GlobalNetwork Time-Average Service Time

        this.register.put("GlobalNetwork_Class1JobsServiceTime", 2.958089587);
        this.register.put("GlobalNetwork_Class2JobsServiceTime", 4.052125751);
        this.register.put("GlobalNetwork_JobsServiceTime", 3.625184809);

        // ***************************************************************** //

        // Cloudlet Throughput

        this.register.put("Cloudlet_Class1Throughput", 2.344298428);
        this.register.put("Cloudlet_Class2Throughput", 3.662966295);
        this.register.put("Cloudlet_Throughput", 6.007264723);

        // Cloud Throughput

        this.register.put("Cloud_Class1Throughput", 1.655701571);
        this.register.put("Cloud_Class2Throughput", 2.587033704);
        this.register.put("Cloud_Throughput", 4.242735276);

        // GlobalNetwork Throughput

        this.register.put("GlobalNetwork_Class1Throughput", 4.0);
        this.register.put("GlobalNetwork_Class2Throughput", 6.25);
        this.register.put("GlobalNetwork_Throughput", 10.25);
    }
}
