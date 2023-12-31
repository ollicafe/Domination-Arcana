package com.ollicafe.dominationarcana;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellListener;
import com.ollicafe.dominationarcana.arcane.SpellManager;
import com.ollicafe.dominationarcana.arcane.alchemyst.iron.IronListener;
import com.ollicafe.dominationarcana.items.ItemListener;
import com.ollicafe.dominationarcana.world.Commands;

import net.md_5.bungee.api.ChatColor;

public class DominationArcana extends JavaPlugin{

	public String sversion;
	private SpellManager spm;

	@Override
	public void onEnable() {
		getLogger().info("[Arcana] has begun initializing...");
		spm = new SpellManager(this);
		SoulManager sm = new SoulManager();
		sm.initSoul();
		msg("Total " + ChatColor.BLUE + "[Soul]" + ChatColor.RESET + " power: " + sm.getTotalSoulPower());
		msg(ChatColor.DARK_RED + "[Magus]" + ChatColor.RESET +" is awakening...");
		msg(ChatColor.DARK_GRAY + "[Ash]" + ChatColor.RESET + " to " + ChatColor.DARK_GRAY + "[Ash]");
		msg(ChatColor.GREEN + "[Alchemyst]" + ChatColor.RESET +" is brewing");
		registerEvents();
		registerCommands();
		
		getLogger().info("[Arcana] has finished initializing | Let absolute power reign");
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new SpellListener(), this);
		pm.registerEvents(new IronListener(), this);
		pm.registerEvents(new ItemListener(this, spm), this);
		
		
	}
	
	public void registerCommands() {

		this.getCommand("soul").setExecutor(new Commands(this, spm));
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
