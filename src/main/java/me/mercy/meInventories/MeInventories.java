package me.mercy.meInventories;

import me.mercy.meInventories.File.YamlFileHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class MeInventories extends JavaPlugin {

    private static MeInventories main;

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;

        /*
            Configuration logic, when the configuration doesn't exist, or its blank,
            it creates the default configuration file
        */
        if (getConfig().getKeys(true).isEmpty()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        /*
            First start logic, when the plugin starts for the first time
            it creates the default inventory file
        */
        if (getConfig().getBoolean("PluginInfo.FirstStart", true)) {
            YamlFileHandler firstStartFile = new YamlFileHandler("plugin/MeInvetories/invetory.yml");
            firstStartFile.set("Inventory.Slots.1.Item.Type", "DIAMOND_SWORD");
            getConfig().set("PluginInfo.FirstStart", false);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic



    }

    public static MeInventories getMain() {
        return main;
    }

}
