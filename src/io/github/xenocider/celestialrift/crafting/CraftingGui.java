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
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingGui implements Listener {
	
	public static Inventory woodworkGui = Bukkit.createInventory(null, 9, "Woodworking Table");
	public static Inventory forgeGui = Bukkit.createInventory(null, 9, "Ancient Forge");
	public static Inventory ovenGui = Bukkit.createInventory(null, 9, "Cook's Oven");
	public static Inventory anvilGui = Bukkit.createInventory(null, 9, "Heavy Anvil");
	public static Inventory bowGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Woodworking Table: Bow");
	public static Inventory staffGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Woodworking Table: Staff");

	public static void init(){
		CelestialRift.log.info("Loading GUIs");
		initWoodworkGui();
	}
	
	private static void initWoodworkGui() {
		
		createDisplay(Material.BOW, woodworkGui, 0, "Craft a Bow", "Click this to craft a bow");
		createDisplay(Material.WOOD_HOE, woodworkGui, 0, "Craft a Staff", "Click this to craft a staff");
		
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
		
		//Woodworking Gui Clicks
		if (event.getInventory().getName().equals(woodworkGui.getName())) {
			if (event.getCurrentItem().getType() == Material.BOW) {
				((Player) event.getWhoClicked()).openInventory(bowGui);
			}
			else if (event.getCurrentItem().getType() == Material.WOOD_HOE) {
				((Player) event.getWhoClicked()).openInventory(staffGui);
			}
			event.setCancelled(true);
		}
		
		//Crafting Gui Clicks
		if (event.getInventory().getType() == InventoryType.BREWING) {
			if (event.getSlotType() == SlotType.FUEL || event.getSlotType() == SlotType.CRAFTING) {
				updateCraftGui((Player) event.getWhoClicked(), event.getInventory());
			}
			else if (event.getSlotType() == SlotType.RESULT) {
				CraftItem((Player) event.getWhoClicked(), event.getInventory());
			}
			else {
				CelestialRift.log.warning("Error occured when " + ((Player) event.getWhoClicked()).getName() + " clicked inside a CR crafting inventory.");
				event.setCancelled(true);
			}
		}
		
	}

	private void updateCraftGui(Player player, Inventory inv) {
		// TODO Auto-generated method stub
		
		if (inv.getName().equals(bowGui.getName())) {
//TODO
		}
		
	}

	private void CraftItem(Player player, Inventory inv) {
		
		//Bow Crafting
		if (inv.getName().equals(bowGui.getName())) {
			//TODO craft bow
		}
		
	}
	

}
