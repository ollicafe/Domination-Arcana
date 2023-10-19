package com.ollicafe.dominationarcana.spells;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.ollicafe.dominationarcana.DominationArcana;

public class SpellListener  implements Listener{
	
	private DominationArcana plugin;
	private Ash ash;
	
	public SpellListener(DominationArcana plugin) {
		this.plugin = plugin;
		ash = new Ash(plugin);
	}
	
	
	@EventHandler
	public void onSpell(SpellEvent e) {
		System.out.println("Spell Casted: " + e.getSpellType().toString());
		System.out.println("Spell Casted: " + e.getPlayer().getName());
		
	}

}
