package io.github.xenocider.celestialrift.crafting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CraftingListener implements Listener {
	
	@EventHandler
	public void onPlayerClick (PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock().getType() == Material.WORKBENCH) {CraftingGui.openWoodworkGui(event.getPlayer());}
			if (event.getClickedBlock().getType() == Material.FURNACE) {CraftingGui.openForgeGui(event.getPlayer());}
			if (event.getClickedBlock().getType() == Material.CAULDRON) {CraftingGui.openOvenGui(event.getPlayer());}
			if (event.getClickedBlock().getType() == Material.ANVIL) {CraftingGui.openAnvilGui(event.getPlayer());}
		}
	}

}
