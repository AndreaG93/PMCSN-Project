package nexteventsimulation.utility;

public class SimulationRegistry {

    private static SimulationRegistry instance = null;

    private int currentSimulationReplicationIndex;
    private int totalSimulationReplications;
    private String outputDirectoryName = "";

    private SimulationAnalyticValueRegistry analyticalValueRegistry;

    private SimulationRegistry() {
    }

    public static SimulationRegistry getInstance() {
        if (instance == null)
            instance = new SimulationRegistry();
        return instance;
    }

    public SimulationAnalyticValueRegistry getAnalyticalValueRegistry() {
        return analyticalValueRegistry;
    }

    public void setAnalyticalValueRegistry(SimulationAnalyticValueRegistry analyticalValueRegistry) {
        this.analyticalValueRegistry = analyticalValueRegistry;
    }

    public int getCurrentSimulationReplicationIndex() {
        return currentSimulationReplicationIndex;
    }

    public void setCurrentSimulationReplicationIndex(int currentSimulationReplicationIndex) {
        this.currentSimulationReplicationIndex = currentSimulationReplicationIndex;
    }

    public void setTotalSimulationReplications(int totalSimulationReplications) {
        this.totalSimulationReplications = totalSimulationReplications;
    }

    public boolean AreSimulationReplicationsTerminate(){
        return this.currentSimulationReplicationIndex == this.totalSimulationReplications;
    }

    public boolean isFirstSimulationReplications(){
        return this.currentSimulationReplicationIndex == 0;
    }

    public int getTotalSimulationReplications() {
        return totalSimulationReplications;
    }

    public String getOutputDirectoryName() {
        return outputDirectoryName;
    }

    public void setOutputDirectoryName(String outputDirectoryName) {
        this.outputDirectoryName = outputDirectoryName;
    }
}
