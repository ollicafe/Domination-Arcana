package com.ollicafe.dominationarcana;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ollicafe.dominationarcana.arcane.SoulManager;
import com.ollicafe.dominationarcana.arcane.SpellListener;
import com.ollicafe.dominationarcana.items.ItemListener;
import com.ollicafe.dominationarcana.world.Commands;

public class DominationArcana extends JavaPlugin{


	@Override
	public void onEnable() {
		System.out.println("Fall");
		registerEvents();
		this.getCommand("soul").setExecutor(new Commands(this));
		SoulManager sm = new SoulManager();
		sm.initSoul();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new SpellListener(), this);
		pm.registerEvents(new ItemListener(this), this);
	}
}
