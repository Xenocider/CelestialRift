package io.github.xenocider.celestialrift;

import io.github.xenocider.celestialrift.crafting.CraftingGui;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CelestialRift extends JavaPlugin {
	
	public static Logger log;

	@Override
    public void onEnable() {
		log = getLogger();
		log.info("Enabling " + Reference.NAME + "[" + Reference.VERSION + "]");
		CraftingGui.init(this);
		getServer().getPluginManager().registerEvents(new CraftingGui(), this);
    }
 
    @Override
    public void onDisable() {
        log.info("Disabling " + Reference.NAME + "[" + Reference.VERSION + "]");
    }
	
}
