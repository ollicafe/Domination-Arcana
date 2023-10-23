package com.ollicafe.dominationarcana.world;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.arcane.Ash;
import com.ollicafe.dominationarcana.arcane.SpellManager;
import com.ollicafe.dominationarcana.arcane.SpellType;

public class Commands implements CommandExecutor{
	
	private DominationArcana plugin;
	private SpellManager sm;
	
	public Commands(DominationArcana plugin) {
		this.plugin = plugin;
		this.sm = new SpellManager(plugin);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("soul")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				
				sm.castSpell(player, SpellType.RETURN_TO_ASH);
				player.sendMessage("return to ash");
				return true;
			} else {
				sender.sendMessage("Consoles can't sit silly");
				return true;
			}
			
		} 
		return false;
	}


}
