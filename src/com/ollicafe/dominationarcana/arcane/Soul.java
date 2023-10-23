package com.ollicafe.dominationarcana.arcane;

import org.bukkit.entity.Player;

public class Soul {
	
	//each player has a soul
	//private color color;
	private int level;
	private int karma;
	private boolean isPlayer;
	
	public Soul(Player player) {
		this.level = 1;
		this.karma = 0;
		this.isPlayer = true;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
