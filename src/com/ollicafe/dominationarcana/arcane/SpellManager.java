package com.ollicafe.dominationarcana.arcane;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.DominationArcana;

public class SpellManager {
	
	public Ash ash;
	public DominationArcana plugin;
	
	public SpellManager(DominationArcana plugin) {
		this.plugin = plugin;
		this.ash = new Ash(plugin);
	}
	
	public void castSpell(Soul soul, SpellType spellType) {
		boolean casted = createEvent(soul, spellType);
		if(casted){//casts spell if event isn't cancelled
			switch(spellType) {
			case RETURN_TO_ASH:
				ash.returnToAsh(soul);
				break;
			case PYROCLASTIC_SURGE:
				ash.pyroclasticSurge(soul);
				break;
			default:
				System.out.println("Spell Type" + '"' + spellType.toString() + '"' );
				break;
			}
			
		}
	}
	
	public boolean createEvent(Soul soul,SpellType spellType) {
		SpellEvent event = new SpellEvent(soul, spellType);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return false;
		return true;
	}

}
