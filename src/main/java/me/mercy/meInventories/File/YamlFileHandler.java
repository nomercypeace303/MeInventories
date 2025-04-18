package me.mercy.meInventories.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlFileHandler {

    private final File file;
    private final FileConfiguration config;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public YamlFileHandler(String filePath) throws IOException {
        this.file = new File(filePath);

        // Crea file e cartelle se non esistono
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        // Carica il file in memoria
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    /*
        Tutti i metodi per il file
    */

    public void set(String path, Object value) {
        config.set(path, value);
    }

    public void save() throws IOException {
        config.save(file);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    /*
        Tutti i getters
    */

    public Object get(String path) {return config.get(path);}
    public String getString(String path) {return config.getString(path);}
    public int getInt(String path) {return config.getInt(path);}
    public boolean getBoolean(String path) {return config.getBoolean(path);}

}
