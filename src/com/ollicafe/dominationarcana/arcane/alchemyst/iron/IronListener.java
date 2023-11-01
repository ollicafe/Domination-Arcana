package com.ollicafe.dominationarcana.arcane.alchemyst.iron;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class IronListener implements Listener{
	
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent e) {
		if(!e.getRightClicked().getType().equals(EntityType.IRON_GOLEM)) return;
		System.out.println("Right Click Iron Golem");
//		if(!e.getHand().equals(EquipmentSlot.HAND))return;
		Player player = e.getPlayer();
		//IronSuit suit = (IronSuit) e.getRightClicked();
		
		Iron iron = new Iron();
		
		iron.suitUp(player, null);
		
		
	}

}
