import ComputationalModels.SingleServerServiceNode;
import NextEventSimulation.NextEventSimulation;

public class EntryPoint {



    public static void main(String args[])
    {

        SingleServerServiceNode x = new SingleServerServiceNode();
        NextEventSimulation sim = new NextEventSimulation(x);

        sim.execute();
    }


}
