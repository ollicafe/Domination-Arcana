package com.ollicafe.dominationarcana.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.spells.Ash;
import com.ollicafe.dominationarcana.spells.SpellType;

public class SpellListener  implements Listener{
	
	private DominationArcana plugin;
	private Ash ash;
	
	public SpellListener(DominationArcana plugin) {
		this.plugin = plugin;
		ash = new Ash(plugin);
	}
	
	
	@EventHandler
	public void onSpell(SpellEvent e) {
		SpellType spell = e.getSpellType();
		switch(spell) {
		case RETURN_TO_ASH:
			ash.returnToAsh(null);
			break;
		}
	}

}
