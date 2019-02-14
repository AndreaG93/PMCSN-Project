package nexteventsimulation;

import java.text.MessageFormat;

public class NextEventSimulationFactory {

    public static NextEventSimulation built(String computationalModelName) {

        String mClassName = MessageFormat.format("{0}.models.{1}.{2}",
                NextEventSimulationFactory.class.getPackage().getName(),
                computationalModelName.toLowerCase(),
                computationalModelName);

        try {
            return (NextEventSimulation) Class.forName(mClassName).getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
