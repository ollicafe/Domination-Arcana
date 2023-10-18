package com.ollicafe.dominationarcana.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.ollicafe.dominationarcana.items.DAItem;
import com.ollicafe.dominationarcana.items.Tome;
import com.ollicafe.dominationarcana.util.ItemUtil;

public class ItemListener implements Listener{
	private ItemUtil iUtil = new ItemUtil();
	
	@EventHandler
	public void onPlayerUseItem(PlayerInteractEvent e) {
		if(e.getItem()==null)return;
		if(!(e.getAction() == Action.RIGHT_CLICK_AIR) 
				&& !e.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				) return;
		Player player = e.getPlayer();
		//get items
		ItemStack mItem = player.getInventory().getItemInMainHand();
		ItemStack oItem = player.getInventory().getItemInOffHand();
		//use ItemUtil to find out what item we are working with.
		DAItem mItemType = iUtil.getDAItemType(mItem);
		DAItem oItemType = iUtil.getDAItemType(oItem);
		
		//this order means if you hold two magic items that aren't a combo, 
		//you use the main hand one first
		
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
