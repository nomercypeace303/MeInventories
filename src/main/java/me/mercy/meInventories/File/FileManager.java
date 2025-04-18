package me.mercy.meInventories.File;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager{

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void saveFile(String filePath) throws IOException {
        File file = new File(filePath);


        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    }


}
