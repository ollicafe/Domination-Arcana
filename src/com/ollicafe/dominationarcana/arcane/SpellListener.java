package com.ollicafe.dominationarcana.arcane;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.ollicafe.dominationarcana.DominationArcana;

public class SpellListener  implements Listener{
	
	
	public SpellListener() {
	}
	
	
	@EventHandler
	public void onSpell(SpellEvent e) {
		System.out.println("Spell Casted " + '"' + e.getSpellType().toString() + '"' + 
				" by [" + e.getPlayer().getName() + "]");
		
	}

}
