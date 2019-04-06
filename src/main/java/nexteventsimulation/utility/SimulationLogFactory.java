package nexteventsimulation.utility;

import java.io.IOException;
import java.util.logging.*;

public class SimulationLogFactory {

    private static Logger LOGGER = null;

    public static Logger getLogger() {

        class MyFormatter extends Formatter {

            public String format(LogRecord record) {
                StringBuilder builder = new StringBuilder(1000);
                builder.append("[").append(record.getLevel()).append("] - ");
                builder.append(formatMessage(record));
                builder.append("\n");
                return builder.toString();
            }
        }

        if (LOGGER == null) {

            try {

                LOGGER = Logger.getAnonymousLogger();
                LOGGER.setUseParentHandlers(false);

                FileHandler fileHandler = new FileHandler("./MyLogFile.log");

                LOGGER.addHandler(fileHandler);

                fileHandler.setFormatter(new MyFormatter());

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return LOGGER;
    }
}
