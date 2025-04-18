package me.mercy.meInventories;

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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MeInventories getMain(){return main;}

}
