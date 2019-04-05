package nexteventsimulation.computationalmodel.model.system;

public class SystemFactory {

    public static System buildSystemUsingRoutingAlgorithm1() {
        return new SystemUsingRoutingAlgorithm1();
    }

    public static System buildSystemUsingRoutingAlgorithm2() {
        return new SystemUsingRoutingAlgorithm2();
    }
}
