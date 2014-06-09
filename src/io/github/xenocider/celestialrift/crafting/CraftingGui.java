package io.github.xenocider.celestialrift.crafting;

import io.github.xenocider.celestialrift.CelestialRift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CraftingGui implements Listener {
	
	public static Inventory woodworkGui = Bukkit.createInventory(null, 9, "Woodworking Table");
	public static Inventory forgeGui = Bukkit.createInventory(null, 9, "Ancient Forge");
	public static Inventory ovenGui = Bukkit.createInventory(null, 9, "Cook's Oven");
	public static Inventory anvilGui = Bukkit.createInventory(null, 9, "Heavy Anvil");
	public static Inventory bowGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Woodworking Table: Bow");
	public static Inventory staffGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Woodworking Table: Staff");
	public static Inventory plankGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Woodworking Table: Planks");
	public static Inventory swordGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Swords");
	public static Inventory axeGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Axes");
	public static Inventory helmetGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Helmet");
	public static Inventory plateGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Chestplate");
	public static Inventory pantsGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Leggings");
	public static Inventory bootsGui = Bukkit.createInventory(null, InventoryType.FURNACE, "Ancient Forge: Boots");

	public static ItemStack Gem_Fire = createItem(Material.GREEN_RECORD,1,"Amber", new ArrayList<String>(Arrays.asList("It seems to have some special proerties")));
	public static ItemStack Gem_Ice = createItem(Material.GREEN_RECORD,1,"Saphire", new ArrayList<String>(Arrays.asList("It seems to have some special proerties")));
	public static ItemStack Gem_Crit = createItem(Material.GREEN_RECORD,1,"Quartz", new ArrayList<String>(Arrays.asList("It seems to have some special proerties")));

	public static final String GEMTYPE_FIRE = "Amber";
	public static final String GEMTYPE_ICE = "Saphire";
	public static final String GEMTYPE_CRIT = "Quartz";
	
	private static final double exponent = 1.2;
	
	private static Plugin plugin;
	
	public static void init(Plugin p){
		
		plugin = p;
		
		CelestialRift.log.info("Loading GUIs");
	}
	
	private static void openWoodworkGui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 9, "Woodworking Table");
		createDisplay(Material.BOW, 1, inv, 3, "Craft a Bow", "Click this to craft a bow");
		createDisplay(Material.WOOD_HOE, 1, inv, 4, "Craft a Staff", "Click this to craft a staff");
		createDisplay(Material.WOOD, 1, inv, 5, "Craft some Planks", "Click this to craft some planks");
		p.openInventory(inv);
	}
	
	private static void openForgeGui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 9, "Ancient Forge");
		createDisplay(Material.IRON_SWORD, 1, inv, 3, "Forge a Sowrd", "Click this to forge a sword");
		createDisplay(Material.IRON_AXE, 1, inv, 4, "Forge an Axe", "Click this to forge an axe");
		createDisplay(Material.FURNACE, 1, inv, 5, "Smelt some Ingots", "Click this to smelt some ingots");
		createDisplay(Material.IRON_HELMET, 1, inv, 4, "Forge a Helmet", "Click this to forge a helmet");
		createDisplay(Material.IRON_CHESTPLATE, 1, inv, 4, "Forge a Chestplate", "Click this to forge a chestplate");
		createDisplay(Material.IRON_LEGGINGS, 1, inv, 4, "Forge some Leggings", "Click this to forge some leggings");
		createDisplay(Material.IRON_BOOTS, 1, inv, 4, "Forge some Boots", "Click this to forge some boots");
		createDisplay(Material.GOLD_NUGGET, 1, inv, 4, "Forge some Rings", "Click this to forge some rings");
		p.openInventory(inv);
	}
	
	public static void createDisplay(Material material, int amount, Inventory inv, int Slot, String name, String lore) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(lore);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		 
		inv.setItem(Slot, item); 
		 
	}
	
	public static ItemStack createItem(Material material, int amount, String name, ArrayList<String> lore) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		final Player player = (Player) event.getWhoClicked();
		final Inventory inv = event.getInventory();
		
		CelestialRift.log.info("CLICKED");
		
		//Woodworking Gui Clicks
		if (inv.getName().equals(woodworkGui.getName())) {
			if (event.getCurrentItem().getType() == Material.BOW) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Woodworking Table: Bow"));
			}
			else if (event.getCurrentItem().getType() == Material.WOOD_HOE) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Woodworking Table: Staff"));
			}
			else if (event.getCurrentItem().getType() == Material.WOOD) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Woodworking Table: Planks"));
			}
			event.setCancelled(true);
		}
		
		//Forge Gui Clicks
		if (inv.getName().equals(forgeGui.getName())) {
			if (event.getCurrentItem().getType() == Material.IRON_SWORD) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Swords"));
			}
			else if (event.getCurrentItem().getType() == Material.IRON_AXE) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Axes"));
			}
			else if (event.getCurrentItem().getType() == Material.IRON_HELMET) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Helmets"));
			}
			else if (event.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Chestplates"));
			}			
			else if (event.getCurrentItem().getType() == Material.IRON_LEGGINGS) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Leggings"));
			}			
			else if (event.getCurrentItem().getType() == Material.IRON_BOOTS) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Boots"));
			}			
			else if (event.getCurrentItem().getType() == Material.FURNACE) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Smelting"));
			}			
			else if (event.getCurrentItem().getType() == Material.GOLD_NUGGET) {
				player.openInventory(Bukkit.createInventory(player, InventoryType.FURNACE, "Ancient Forge: Rings"));
			}
			event.setCancelled(true);
		}
		
		//Crafting Gui Clicks
		if (inv.getType() == InventoryType.FURNACE) {
			if (event.getSlotType() == SlotType.FUEL || event.getSlotType() == SlotType.CRAFTING) {
				updateCraftGui(player, inv);
				Bukkit.getServer().getScheduler()
		        .scheduleSyncDelayedTask(plugin, new Runnable() {
		            @Override
		            public void run() {
						updateCraftGui(player, inv);
		            }
		        }, 1);
				CelestialRift.log.info("updated");
			}
			else if (event.getSlotType() == SlotType.RESULT) {
				CraftItem(player, inv);
				CelestialRift.log.info("crafted");
				event.setCancelled(true);
			}
			else {
				//CelestialRift.log.warning("Error occured when " + player.getName() + " clicked inside a CR crafting inventory.");
			}
		}
		
	}

	private void updateCraftGui(final Player player, Inventory inv) {
		int resources = 0;
		String gemType = null;
		
		
		//Weapon crafting
		if (inv.getName().equals(bowGui.getName()) || inv.getName().equals(staffGui.getName()) || inv.getName().equals(swordGui.getName()) || inv.getName().equals(axeGui.getName())) {
		if (inv.getName().equals(bowGui.getName()) || inv.getName().equals(staffGui.getName())) {
			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.WOOD) {
				resources = resources + inv.getItem(0).getAmount();
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.WOOD) {
				resources = resources + inv.getItem(1).getAmount();
			}
		}
		else if (inv.getName().equals(swordGui.getName()) || inv.getName().equals(axeGui.getName())) {
			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.IRON_INGOT) {
				resources = resources + inv.getItem(0).getAmount();
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.IRON_INGOT) {
				resources = resources + inv.getItem(1).getAmount();
			}
		}

			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.GREEN_RECORD) {
				ItemStack item = inv.getItem(0);
				if (item.getItemMeta().getDisplayName() == Gem_Fire.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_FIRE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Ice.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_ICE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Crit.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_CRIT;
				}
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.GREEN_RECORD) {
				ItemStack item = inv.getItem(1);
				if (item.getItemMeta().getDisplayName() == Gem_Fire.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_FIRE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Ice.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_ICE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Crit.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_CRIT;
				}
			}
			if (resources >= 1) {
				ItemStack item = null;
				int level = (int) Math.pow(resources, (1.0/exponent));
				if (level > 32) {level = 32;}
				int minDam = 6+2*level;
				int maxDam = minDam + level;
				if (inv.getName().equals(bowGui.getName())) {
					if (gemType != null) {item = createItem(Material.BOW, 1, "Crafted Bow", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + minDam + "-" + maxDam,"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.BOW, 1, "Crafted Bow", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + minDam + "-" + maxDam,"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(staffGui.getName())) {
					if (gemType != null) {item = createItem(Material.WOOD_HOE, 1, "Crafted Staff", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + minDam + "-" + maxDam,"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.WOOD_HOE, 1, "Crafted Staff", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + minDam + "-" + maxDam,"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(swordGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_SWORD, 1, "Crafted Sword", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + (int) (minDam/2) + "-" + (int) (maxDam/2),"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_SWORD, 1, "Crafted Sword", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + (int) (minDam/2) + "-" + (int) (maxDam/2),"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(axeGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_AXE, 1, "Crafted Axe", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + (int) (minDam/2) + "-" + (int) (maxDam/2),"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_AXE, 1, "Crafted Axe", new ArrayList<String>(Arrays.asList("Level: " + level,"Dmg: " + (int) (minDam/2) + "-" + (int) (maxDam/2),"Crafted by: " + player.getDisplayName())));}
				}
				inv.setItem(2, item);
			}
			else {
				inv.clear(2);
			}
		}
		
		//Resource Crafting
		if (inv.getName().equals(plankGui.getName())) {
			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.LOG) {
				resources = resources + inv.getItem(0).getAmount();
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.LOG) {
				resources = resources + inv.getItem(1).getAmount();
			}
			if (resources >= 4) {
				ItemStack item;
				item = createItem(Material.WOOD, resources/4, "Crafted Planks", new ArrayList<String>(Arrays.asList("Resource used in crafting","Crafted by: " + player.getDisplayName())));
				inv.setItem(2, item);
			}
			else {
				inv.clear(2);
			}
		}
		
		if (inv.getName().equals(helmetGui.getName()) || inv.getName().equals(plateGui.getName()) || inv.getName().equals(pantsGui.getName()) || inv.getName().equals(bootsGui.getName())) {
			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.IRON_INGOT) {
				resources = resources + inv.getItem(0).getAmount();
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.IRON_INGOT) {
				resources = resources + inv.getItem(1).getAmount();
			}
			if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.GREEN_RECORD) {
				ItemStack item = inv.getItem(0);
				if (item.getItemMeta().getDisplayName() == Gem_Fire.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_FIRE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Ice.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_ICE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Crit.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_CRIT;
				}
			}
			if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.GREEN_RECORD) {
				ItemStack item = inv.getItem(1);
				if (item.getItemMeta().getDisplayName() == Gem_Fire.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_FIRE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Ice.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_ICE;
				}
				else if (item.getItemMeta().getDisplayName() == Gem_Crit.getItemMeta().getDisplayName()) {
					gemType = GEMTYPE_CRIT;
				}
			}
			
			if (resources >= 1) {
				ItemStack item = null;
				int level = (int) Math.pow(resources, (1.0/exponent));
				if (level > 32) {level = 32;}
				int armour = (int) (6+4*level);
				if (inv.getName().equals(helmetGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_HELMET, 1, "Crafted Helmet", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour/1.5),"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_HELMET, 1, "Crafted Helmet", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour/1.5),"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(plateGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_CHESTPLATE, 1, "Crafted Chestplate", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour*1.5),"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_CHESTPLATE, 1, "Crafted Chestplate", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour*1.5),"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(pantsGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_LEGGINGS, 1, "Crafted Pants", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + armour,"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_LEGGINGS, 1, "Crafted Pants", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + armour,"Crafted by: " + player.getDisplayName())));}
				}
				else if (inv.getName().equals(bootsGui.getName())) {
					if (gemType != null) {item = createItem(Material.IRON_BOOTS, 1, "Crafted Boots", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour/1.5),"Gem: " + gemType,"Crafted by: " + player.getDisplayName())));}
					else {item = createItem(Material.IRON_BOOTS, 1, "Crafted Boots", new ArrayList<String>(Arrays.asList("Level: " + level,"Arm: " + (int) (armour/1.5),"Crafted by: " + player.getDisplayName())));}
				}
				inv.setItem(2, item);
			}
			else {
				inv.clear(2);
			}
		}
		
		
        player.updateInventory();
		
	}

	private void CraftItem(final Player player, Inventory inv) {
		
		int resources = 0;
		
		if (inv.getItem(2) != null) { 
			updateCraftGui(player,inv);
			//Wood weapons Crafting
			if (inv.getName().equals(bowGui.getName()) || inv.getName().equals(staffGui.getName())) {
				if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.WOOD) {
					resources = resources + inv.getItem(0).getAmount();
				}
				if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.WOOD) {
					resources = resources + inv.getItem(1).getAmount();
				}
				int level = (int) Math.pow(resources, (1.0/exponent));
				int cost = (int) Math.pow(level, exponent);
				
				ItemStack extra = new ItemStack(Material.WOOD,resources - cost);
				ItemStack item = inv.getItem(2);
				
				player.closeInventory();
				
				//Try to add the items to the player's inventory, or else it will drop the remaining on the ground
				HashMap<Integer, ItemStack> nope = player.getInventory().addItem(item,extra);
				for(Entry<Integer, ItemStack> entry : nope.entrySet())
				{   
					player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
				}
			}
			
			//Plank crafting
			if (inv.getName().equals(plankGui.getName())) {
				if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.LOG) {
					resources = resources + inv.getItem(0).getAmount();
				}
				if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.LOG) {
					resources = resources + inv.getItem(1).getAmount();
				}
				ItemStack extra = new ItemStack(Material.LOG,resources - (resources/4)*4);
				ItemStack item = inv.getItem(2);
				player.closeInventory();
				
				//Try to add the items to the player's inventory, or else it will drop the remaining on the ground
				HashMap<Integer, ItemStack> nope = player.getInventory().addItem(item,extra);
				for(Entry<Integer, ItemStack> entry : nope.entrySet())
				{   
					player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
				}
			}
			
			//Forge weapons
			if (inv.getName().equals(swordGui.getName()) || inv.getName().equals(axeGui.getName())) {
				if (inv.getItem(0) != null && inv.getItem(0).getType() == Material.IRON_INGOT) {
					resources = resources + inv.getItem(0).getAmount();
				}
				if (inv.getItem(1) != null && inv.getItem(1).getType() == Material.IRON_INGOT) {
					resources = resources + inv.getItem(1).getAmount();
				}
				int level = (int) Math.pow(resources, (1.0/exponent));
				int cost = (int) Math.pow(level, exponent);
				
				ItemStack extra = new ItemStack(Material.IRON_INGOT,resources - cost);
				ItemStack item = inv.getItem(2);
				
				player.closeInventory();
				
				//Try to add the items to the player's inventory, or else it will drop the remaining on the ground
				HashMap<Integer, ItemStack> nope = player.getInventory().addItem(item,extra);
				for(Entry<Integer, ItemStack> entry : nope.entrySet())
				{   
					player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
				}
			}
			
			Bukkit.getServer().getScheduler()
	        .scheduleSyncDelayedTask(plugin, new Runnable() {
	            @Override
	            public void run() {
					player.updateInventory();
	            }
	        }, 1);
			
		}
		
	}
	
	
	@EventHandler
	public void onPlayerClick (PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock().getType() == Material.WORKBENCH) {
				openWoodworkGui(event.getPlayer());
				event.setCancelled(true);
			}
			if (event.getClickedBlock().getType() == Material.FURNACE) {
				openForgeGui(event.getPlayer());
				event.setCancelled(true);
			}
			//if (event.getClickedBlock().getType() == Material.CAULDRON) {event.getPlayer().openInventory(CraftingGui.ovenGui);}
			//if (event.getClickedBlock().getType() == Material.ANVIL) {event.getPlayer().openInventory(CraftingGui.anvilGui);}
		}
	}
	

}
