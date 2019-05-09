package nexteventsimulation.utility;

import java.io.File;

public class FileManagement {

    private static void purgeDirectory(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory())
                purgeDirectory(file);
            file.delete();
        }
    }

    public static void createOrPurgeDirectory(String directoryName) {

        File directory = new File(directoryName);
        if (!directory.exists())
            directory.mkdir();
        else
            purgeDirectory(directory);
    }
}
