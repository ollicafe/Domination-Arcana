package com.ollicafe.dominationarcana.arcane;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Soul {
	
	//each player has a soul
	//private color color;
	private int level;
	private int karma;
	private final boolean isPlayer;
	private final Entity entity;
	
	public Soul(Player player) {
		this.level = 1;
		this.karma = 0;
		this.isPlayer = true;
		this.entity = (Entity) player;
	}
	
	public Soul(Entity entity) {
		this.level = 1;
		this.karma = 0;
		this.isPlayer = false;
		this.entity = entity;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public boolean isPlayer() {
		return isPlayer;
	}
	
	
}
