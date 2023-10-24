package com.ollicafe.dominationarcana.arcane.alchemyst.iron;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.arcane.Soul;

public class Iron {
	
	
	public void openCrafting() {
		//iron crafting
	}
	
	public boolean suitUp(Player player, Entity suit) {
		
		//this is when the player right clicks on the suit
		
		
		
		return true;
	}
	
	public boolean summonSuit(Soul soul) {
		Player player;
		if(soul.isPlayer()) 
			player = (Player)soul.getEntity();
		else 
			return false;
		
		//check if holding the beacon
		//beacon is a throwable bottle?
		//creates a beacon effect where it lands
		//armor lands there
		
		//boss bar loading bar?
		
		
		
		
		return true;
		
	}
	
	
	
	

}
