package com.ollicafe.dominationarcana.arcane;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class SoulManager {
	
	private static HashMap<Player, Soul> souls = new HashMap<Player, Soul>();
	

	public Soul getSoul(Player player) {
		Soul soul;
		if(souls.containsKey(player))
			soul = souls.get(player); 
		else {
			soul = new Soul(player);
			souls.put(player, soul);
		}
		return soul;
	}
	
	
	//on enable and disable, read and write to data file
	public boolean initSoul() {
		return false;
	}
	

}
