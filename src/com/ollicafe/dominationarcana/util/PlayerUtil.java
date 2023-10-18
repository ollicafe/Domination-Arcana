package com.ollicafe.dominationarcana.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerUtil {
	
	public List<Player> getPlayers(){
		List<Player> players = new ArrayList<Player>();
		for(Player player: Bukkit.getOnlinePlayers()) {
			players.add(player);
		}
		
		return players;
	}
	
	public List<Player> getPlayersAround(Location loc, int radius){

		List<Player> players = new ArrayList<Player>();
		
		
		
		return players;
	}

}
