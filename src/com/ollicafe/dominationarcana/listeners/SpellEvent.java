package com.ollicafe.dominationarcana.listeners;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.ollicafe.dominationarcana.spells.Soul;
import com.ollicafe.dominationarcana.spells.SpellType;

public class SpellEvent extends Event{

	private static final HandlerList HANDLERS = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
    
    //---------Event stuff here -----------
    
    public final SpellType spellType;
    
    
    public SpellEvent(SpellType spellType, Soul soul) {
    	this.spellType = spellType;
    }
    
    public SpellType getSpellType() {
    	return spellType;
    }
    
    
	
}
