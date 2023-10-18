package com.ollicafe.dominationarcana;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.ollicafe.dominationarcana.listeners.ItemListener;
import com.ollicafe.dominationarcana.listeners.SpellListener;

public class DominationArcana extends JavaPlugin{


	@Override
	public void onEnable() {
		System.out.println("Fall");
		registerEvents();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerEvents() {
		PluginManager pm = this.getServer().getPluginManager();
		//pm.registerEvents(new SpellListener(), this);
		pm.registerEvents(new ItemListener(), this);
	}
}
