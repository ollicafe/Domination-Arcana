package com.ollicafe.dominationarcana.world;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.arcane.Soul;
import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellManager;
import com.ollicafe.dominationarcana.arcane.SpellType;

public class Commands implements CommandExecutor{
	
	private DominationArcana plugin;
	private SpellManager spm;
	private SoulManager som;
	
	public Commands(DominationArcana plugin,SpellManager spm) {
		this.plugin = plugin;
		this.spm = spm;
		this.som = new SoulManager();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("soul")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				
				//spm.castSpell(player, SpellType.RETURN_TO_ASH);
				Soul soul = som.getSoul(player);
				soul.setLevel(soul.getLevel() + 1);
				player.sendMessage("Your level is: " + soul.getLevel());
				spm.castSpell(soul, SpellType.SUMMON_SUIT);
				return true;
			} else {
				sender.sendMessage("Consoles can't sit silly");
				return true;
			}
			
		} 
		return false;
	}


}
