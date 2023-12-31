package com.ollicafe.dominationarcana.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.arcane.Soul;
import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellManager;
import com.ollicafe.dominationarcana.arcane.SpellType;
import com.ollicafe.dominationarcana.util.ItemUtil;

public class ItemListener implements Listener{
	private ItemUtil iUtil = new ItemUtil();
	private DominationArcana plugin;
	private SpellManager spm;
	private SoulManager som;
	
	public ItemListener(DominationArcana plugin, SpellManager spm) {
		this.plugin = plugin;
		//initialize all the spells
		this.spm = spm;
		this.som = new SoulManager();
	}
	
	@EventHandler
	public void onPlayerUseItem(PlayerInteractEvent e) {
		if(e.getItem()==null)return;
		if(!(e.getAction() == Action.RIGHT_CLICK_AIR) 
				&& !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				) return;
		if(!e.getHand().equals(EquipmentSlot.HAND))return;
		Player player = e.getPlayer();
		
		//get items
		ItemStack mItem = player.getInventory().getItemInMainHand();
		ItemStack oItem = player.getInventory().getItemInOffHand();
		//use ItemUtil to find out what item we are working with.
		DAItem mItemType = iUtil.getDAItemType(mItem);
		DAItem oItemType = iUtil.getDAItemType(oItem);
		
		//this order means if you hold two magic items that aren't a combo, 
		//you use the main hand one first
		Soul soul = som.getSoul(player);
		
		//temp code
		if(mItem.equals(new ItemStack(Material.NETHER_STAR)) 
				&& oItem.equals(new ItemStack(Material.BOOK))) {
			spm.castSpell(soul, SpellType.RETURN_TO_ASH);
		}
		if(mItem.equals(new ItemStack(Material.BLAZE_ROD)) 
				&& oItem.equals(new ItemStack(Material.BOOK))) {
			spm.castSpell(soul, SpellType.PYROCLASTIC_SURGE);
			
		}
		//check for combos first
		if(!mItemType.equals(DAItem.NULL) && !oItemType.equals(DAItem.NULL)) {
			
			
			return;
		}
		
		//check then main hand
		if(!mItemType.equals(DAItem.NULL)) {
			return;
		}
		
		//check offhand
		if(!oItemType.equals(DAItem.NULL)) {
			return;
		}
		
		
		
	}

}
