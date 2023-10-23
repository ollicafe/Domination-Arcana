package com.ollicafe.dominationarcana.spells;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.DominationArcana;

public class SpellManager {
	
	public Ash ash;
	public DominationArcana plugin;
	
	public SpellManager(DominationArcana plugin) {
		this.plugin = plugin;
	}
	
	public void castSpell(Player player, SpellType spellType) {
		boolean casted = createEvent(player, spellType);
		if(casted){//casts spell if event isn't cancelled
			switch(spellType) {
			case RETURN_TO_ASH:
				ash.returnToAsh(player.getLocation());
				break;
			case PYROCLASTIC_SURGE:
				ash.pyroclasticSurge(player);
				break;
			default:
				System.out.println("Spell Type" + '"' + spellType.toString() + '"' );
				break;
			}
			
		}
	}
	
	public boolean createEvent(Player player,SpellType spellType) {
		SpellEvent event = new SpellEvent(player, spellType);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCancelled()) return false;
		return true;
	}

}
