package com.ollicafe.dominationarcana.arcane.alchemyst.iron;

import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.ollicafe.dominationarcana.arcane.Soul;

import net.minecraft.server.level.WorldServer;

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
		
		//for now, just make the suit
		//IronSuit suit = new IronSuit(player.getLocation());
		//WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
		//world.addFreshEntity(suit, SpawnReason.BUILD_IRONGOLEM);
		
		
		return true;
		
	}
	
	
	
	

}
