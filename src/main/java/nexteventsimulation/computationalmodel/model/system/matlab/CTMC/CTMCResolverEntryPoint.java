package nexteventsimulation.computationalmodel.model.system.matlab.CTMC;

public class CTMCResolverEntryPoint {

    public static void main(String args[]){

        CTMCResolverScriptGenerator CTMCUsingRoutingAlgorithm1 = new ResolverUsingRoutingAlgorithm1();
        CTMCResolverScriptGenerator CTMCUsingRoutingAlgorithm2 = new ResolverUsingRoutingAlgorithm2();

        CTMCUsingRoutingAlgorithm1.startScriptGeneration();
        CTMCUsingRoutingAlgorithm2.startScriptGeneration();
    }
}
