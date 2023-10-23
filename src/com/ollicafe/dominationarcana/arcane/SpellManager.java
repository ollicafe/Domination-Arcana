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
			//Ash
			case RETURN_TO_ASH:
				casted = ash.returnToAsh(soul);
				break;
			case PYROCLASTIC_SURGE:
				casted = ash.pyroclasticSurge(soul);
				break;
			//Fire
			case FIREBALL:
				break;
			//Iron
			case SUMMON_SUIT:
				break;
			default:
				System.out.println("Spell Type" + '"' + spellType.toString() + '"' );
				break;
			}
		}
		if(!casted) {
			System.out.println("Spell Type" + '"' + spellType.toString() + '"' + " failed to cast" );
		}
	}
	
	public boolean createEvent(Soul soul,SpellType spellType) {
		SpellEvent event = new SpellEvent(soul, spellType);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return false;
		return true;
	}

}
