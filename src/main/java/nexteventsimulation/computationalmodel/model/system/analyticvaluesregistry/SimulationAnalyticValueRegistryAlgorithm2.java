package nexteventsimulation.computationalmodel.model.system.analyticvaluesregistry;

import nexteventsimulation.utility.SimulationAnalyticValueRegistry;

import java.util.HashMap;

public class SimulationAnalyticValueRegistryAlgorithm2 extends SimulationAnalyticValueRegistry {

    @Override
    protected void loadDataIntoRegistry() {

        this.register = new HashMap<String, Double>();

        // Cloudlet Time-Average Population

        this.register.put("Cloudlet_Class1JobsNumber", 8.884108755);
        this.register.put("Cloudlet_Class2JobsNumber", 9.608670684);
        this.register.put("Cloudlet_JobsNumber", 18.492779440);

        // Cloud Time-Average Population

        this.register.put("Cloud_Class1JobsNumber", 0.008604239);
        this.register.put("Cloud_Class2JobsNumber", 16.644920866);
        this.register.put("Cloud_JobsNumber", 16.653525106);

        // GlobalNetwork Time-Average Population

        this.register.put("GlobalNetwork_Class1JobsNumber", 8.892712995);
        this.register.put("GlobalNetwork_Class2JobsNumber", 27.375749424);
        this.register.put("GlobalNetwork_JobsNumber", 36.2684624);

        // ***************************************************************** //

        // Cloudlet Time-Average Service Time

        this.register.put("Cloudlet_Class1JobsServiceTime", 2.222222222);
        this.register.put("Cloudlet_Class2JobsServiceTime", 3.703770377);
        this.register.put("Cloudlet_JobsServiceTime", 2.804406796);

        // Cloud Time-Average Service Time

        this.register.put("Cloud_Class1JobsServiceTime", 4.0);
        this.register.put("Cloud_Class2JobsServiceTime", 4.545454545);
        this.register.put("Cloud_JobsServiceTime", 4.545134323);

        // GlobalNetwork Time-Average Service Time

        this.register.put("GlobalNetwork_Class1JobsServiceTime", 2.223178248);
        this.register.put("GlobalNetwork_Class2JobsServiceTime", 4.380119907);
        this.register.put("GlobalNetwork_JobsServiceTime", 3.538386577);

        // ***************************************************************** //

        // Cloudlet Throughput

        this.register.put("Cloudlet_Class1Throughput", 3.997848940);
        this.register.put("Cloudlet_Class2Throughput", 2.588117409);
        this.register.put("Cloudlet_Throughput", 6.585966349);

        // Cloud Throughput

        this.register.put("Cloud_Class1Throughput", 0.002151059);
        this.register.put("Cloud_Class2Throughput", 3.661882590);
        this.register.put("Cloud_Throughput", 3.664033650);

        // GlobalNetwork Throughput

        this.register.put("GlobalNetwork_Class1Throughput", 4.0);
        this.register.put("GlobalNetwork_Class2Throughput", 6.25);
        this.register.put("GlobalNetwork_Throughput", 10.25);
    }
}
