package me.mercy.meInventories.File;

import me.mercy.meInventories.MeInventories;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class ConfigsHandler {

    private final String path;
    private final Plugin plugin = MeInventories.getMain(); 

    public ConfigsHandler(String path) {
        this.path = path.endsWith("/") ? path : path + "/";
    }

    public ConfigurationSection loadSectionComponents(String inventoryFile) {
        String filePath = path + inventoryFile;
        YamlFileHandler file = new YamlFileHandler(filePath);
        return file.getSection("Components");
    }

    public Map<String, ConfigurationSection> getComponents(String inventoryFile) {
        ConfigurationSection componentsSection = loadSectionComponents(inventoryFile);
        Map<String, ConfigurationSection> componentsMap = new HashMap<>();

        if (componentsSection == null) {
            return componentsMap;
        }

        for (String key : componentsSection.getKeys(false)) {
            ConfigurationSection section = componentsSection.getConfigurationSection(key);
            if (section != null) {
                componentsMap.put(key, section);
            }
        }

        return componentsMap;
    }

    public String getComponentType(String inventoryFile, String key) {
        ConfigurationSection component = getComponents(inventoryFile).get(key);

        if (component == null) {
            plugin.getLogger().severe("The component " + key + " doesn't exist in the file " + inventoryFile);
            return null;
        }

        for (String pathKey : component.getKeys(false)) {
            if (pathKey.equalsIgnoreCase("Type")) {
                return component.getString(pathKey);
            }
        }

        plugin.getLogger().severe("The component " + key + " has no Type defined.");
        return null;
    }

    public String getComponentAttribute(String inventoryFile, String key, String attribute) {
        ConfigurationSection component = getComponents(inventoryFile).get(key);

        if (component == null) {
            plugin.getLogger().severe("The component " + key + " doesn't exist in the file " + inventoryFile);
            return null;
        }

        for (String pathKey : component.getKeys(false)) {
            if (pathKey.equalsIgnoreCase(attribute)) {
                return component.getString(pathKey);
            }
        }

        plugin.getLogger().severe("The component " + key + " has no " + attribute + " defined.");
        return null;
    }
}
