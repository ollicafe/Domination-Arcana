package com.ollicafe.dominationarcana;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellListener;
import com.ollicafe.dominationarcana.arcane.alchemyst.iron.IronListener;
import com.ollicafe.dominationarcana.items.ItemListener;
import com.ollicafe.dominationarcana.world.Commands;

public class DominationArcana extends JavaPlugin{

	public String sversion;

	@Override
	public void onEnable() {
		registerEvents();
		this.getCommand("soul").setExecutor(new Commands(this));
		SoulManager sm = new SoulManager();
		sm.initSoul();
		getLogger().info("[Arcana] has begun initializing...");
		
		System.out.println("Total soul power: " + sm.getTotalSoulPower());
		System.out.println("[Magus] is awakening");
		
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
}
