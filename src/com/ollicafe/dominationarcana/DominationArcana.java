package com.ollicafe.dominationarcana;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellListener;
import com.ollicafe.dominationarcana.arcane.alchemyst.iron.IronListener;
import com.ollicafe.dominationarcana.items.ItemListener;
import com.ollicafe.dominationarcana.world.Commands;

import net.md_5.bungee.api.ChatColor;

public class DominationArcana extends JavaPlugin{

	public String sversion;

	@Override
	public void onEnable() {
		registerEvents();
		this.getCommand("soul").setExecutor(new Commands(this));
		SoulManager sm = new SoulManager();
		sm.initSoul();
		getLogger().info("[Arcana] has begun initializing...");
		msg("Total " + ChatColor.BLUE + "[Soul]" + ChatColor.RESET + " power: " + sm.getTotalSoulPower());
		msg(ChatColor.DARK_RED + "[Magus]" + ChatColor.RESET +" is awakening...");
		msg(ChatColor.BLACK + "[Ash]" + ChatColor.RESET + " to " + ChatColor.BLACK + "[Ash]");
		msg(ChatColor.GREEN + "[Alchemyst]" + ChatColor.RESET +" is brewing");
		
		getLogger().info("[Arcana] has finished initializing | Let absolute power reign");
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new SpellListener(), this);
		pm.registerEvents(new IronListener(), this);
		pm.registerEvents(new ItemListener(this), this);
	}
	
	private boolean setupManager() {
		sversion = "N/A";
		
		try {
			sversion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		} catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
		
		if(sversion.equals("v1")) {
			
		}
		
		return "tab" != null;
	}
	
	public void msg(String string) {
		getServer().getConsoleSender().sendMessage(string);
	}
}
