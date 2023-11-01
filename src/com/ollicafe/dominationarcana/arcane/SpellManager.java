package com.ollicafe.dominationarcana.arcane;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.arcane.alchemyst.iron.Iron;
import com.ollicafe.dominationarcana.arcane.magus.ash.Ash;

public class SpellManager {
	
	private Ash ash;
	private Iron iron;
	private DominationArcana plugin;
	
	public SpellManager(DominationArcana plugin) {
		this.plugin = plugin;
		this.ash = new Ash(plugin);
		this.iron = new Iron();
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
				casted = iron.summonSuit(soul);
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
	
	public void cleanup() {
		//go through each domination and clean it up
		
	}

}
