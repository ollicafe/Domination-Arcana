package com.ollicafe.dominationarcana.listeners;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.ollicafe.dominationarcana.spells.Soul;
import com.ollicafe.dominationarcana.spells.SpellType;

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
    
    
    public SpellEvent(SpellType spellType, Soul soul) {
    	this.spellType = spellType;
    	this.isCancelled = false;
    }
    
    public SpellType getSpellType() {
    	return spellType;
    }
    
    
    
    
	
}
