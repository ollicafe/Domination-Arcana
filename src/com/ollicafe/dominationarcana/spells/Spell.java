package com.ollicafe.dominationarcana.spells;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.listeners.SpellEvent;

public abstract class Spell {
	
	protected Element element;
	
	public abstract void castSpell(Player player, SpellType spellType);
	
	public boolean createEvent(SpellType spellType) {
		SpellEvent event = new SpellEvent(spellType, null);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return false;
		return true;
	}

}
