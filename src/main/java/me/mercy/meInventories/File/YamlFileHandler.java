package me.mercy.meInventories.File;

import me.mercy.meInventories.MeInventories;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class YamlFileHandler {

    private final File file;
    private final FileConfiguration config;
    private final Plugin plugin = MeInventories.getMain();

    /*
        Costruttore
    */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public YamlFileHandler(String filePath) {
        this.file = new File(filePath);

        try {
            // Crea file e cartelle se non esistono
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            plugin.getLogger().severe("Errore nella creazione del file: " + filePath);
            plugin.getLogger().severe(e.toString());
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

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().severe("Errore nel salvataggio di: " + file.getName());
            plugin.getLogger().severe(e.toString());
        }
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
