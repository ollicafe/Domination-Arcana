package com.ollicafe.dominationarcana.spells;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class Spell {
	
	protected Element element;
	
	public abstract void castSpell(Player player, SpellType spellType);
	
	public boolean createEvent(Player player,SpellType spellType) {
		SpellEvent event = new SpellEvent(player, spellType);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return false;
		return true;
	}

}
