package io.github.xenocider.celestialrift.crafting;

import io.github.xenocider.celestialrift.CelestialRift;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingGui implements Listener {
	
	public static Inventory woodworkGui = Bukkit.createInventory(null, 9, "Woodworking Table");
	public static Inventory forgeGui = Bukkit.createInventory(null, 9, "Ancient Forge");
	public static Inventory ovenGui = Bukkit.createInventory(null, 9, "Cook's Oven");
	public static Inventory anvilGui = Bukkit.createInventory(null, 9, "Heavy Anvil");
	public static Inventory bowGui = Bukkit.createInventory(null, InventoryType.BREWING, "Woodworking Table: Bow");
	
	public static void init(){
		CelestialRift.log.info("Loading GUIs");
		initWoodworkGui();
	}
	
	private static void initWoodworkGui() {
		
		createDisplay(Material.BOW, woodworkGui, 0, "Craft a Bow", "Click this to craft a bow");
		createDisplay(Material.WOOD_HOE, woodworkGui, 0, "Craft a Staff", "Click this to craft a staff");
		
	}

	public static void openWoodworkGui(Player player) {
	}

	public static void openForgeGui(Player player) {
		// TODO Auto-generated method stub
		
	}

	public static void openOvenGui(Player player) {
		// TODO Auto-generated method stub
		
	}

	public static void openAnvilGui(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	public static void createDisplay(Material material, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(lore);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		 
		inv.setItem(Slot, item); 
		 
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getInventory().getName().equals(woodworkGui.getName())) {
			if (event.getCurrentItem().getType() == Material.BOW) {
				openBowCraftingGui((Player) event.getWhoClicked());
			}
			else if (event.getCurrentItem().getType() == Material.WOOD_HOE) {
				openStaffCraftingGui((Player) event.getWhoClicked());
			}
		}
	}
	
	private void openBowCraftingGui(Player whoClicked) {
		// TODO Auto-generated method stub
		
	}
	
	private void openStaffCraftingGui(Player whoClicked) {
		// TODO Auto-generated method stub
		
	}

}
