package com.ollicafe.dominationarcana.arcane.magus.ash;

import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import com.ollicafe.dominationarcana.DominationArcana;

public class AshDust {
	
	//this class is a a collection of particle dust in the world
	
	private int x,y,z;
	private World world;
	private boolean exists;
	private DominationArcana plugin;
	
	//probably include a armor stand hitbox to interact
	
	public AshDust(DominationArcana plugin) {
		this.plugin = plugin;
	}
	
	public void createCloud() {
		
		
		new BukkitRunnable() {
			

			public void run() {
				while(exists) {
					//create particles at coordinates
					
					
					//check for collisions and create events?
					
					
				}
				cancel();
			}
		}.runTaskTimer(plugin.getPlugin(plugin.getClass()), 0 ,0);
	}

}
