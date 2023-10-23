package com.ollicafe.dominationarcana.arcane;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpellEvent extends Event{

	private static final HandlerList HANDLERS = new HandlerList();
	private boolean isCancelled;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
    
    public boolean isCancelled() {
    	return isCancelled;
    }
    
    public void setCancelled(boolean isCancelled) {
    	this.isCancelled = isCancelled;
    }
    
    //---------Event stuff here -----------
    
    private final SpellType spellType;
    private final Player player;
    
    
    public SpellEvent(Player player, SpellType spellType) {
    	this.spellType = spellType;
    	this.isCancelled = false;
    	this.player = player;
    }
    
    public SpellType getSpellType() {
    	return spellType;
    }
    
    public Player getPlayer() {
    	return player;
    }
    
    
    
	
}
