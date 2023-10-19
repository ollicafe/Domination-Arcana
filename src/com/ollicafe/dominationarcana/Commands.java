package com.ollicafe.dominationarcana;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.ollicafe.dominationarcana.spells.Ash;

public class Commands implements CommandExecutor{
	
	private DominationArcana plugin;
	
	public Commands(DominationArcana plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("ash")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				Ash ash = new Ash(plugin);
				
				ash.returnToAsh(player.getLocation());
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
