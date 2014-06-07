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
			if (event.getClickedBlock().getType() == Material.WORKBENCH) {event.getPlayer().openInventory(CraftingGui.woodworkGui);}
			if (event.getClickedBlock().getType() == Material.FURNACE) {event.getPlayer().openInventory(CraftingGui.forgeGui);}
			if (event.getClickedBlock().getType() == Material.CAULDRON) {event.getPlayer().openInventory(CraftingGui.ovenGui);}
			if (event.getClickedBlock().getType() == Material.ANVIL) {event.getPlayer().openInventory(CraftingGui.anvilGui);}
		}
	}

}
