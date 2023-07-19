package septem150.septemtweaks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean genOres = false;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        String comment;

        comment = "Whether or not to generate this mod's ores. [default: true]";
        genOres = configuration.getBoolean("genOres", Configuration.CATEGORY_GENERAL, genOres, comment);

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
