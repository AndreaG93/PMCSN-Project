package nexteventsimulation.computationalmodel;

import java.text.MessageFormat;

public class ComputationalModelFactory {

    public static ComputationalModel built(String computationalModelName, String version) {

        String mClassName = MessageFormat.format("{0}.model.{1}.{1}{2}",
                ComputationalModelFactory.class.getPackage().getName(),
                computationalModelName.toLowerCase(),
                version);

        try {
            return (ComputationalModel) Class.forName(mClassName).getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}