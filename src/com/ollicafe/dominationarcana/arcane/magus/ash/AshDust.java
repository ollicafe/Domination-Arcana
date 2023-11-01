package com.ollicafe.dominationarcana.arcane.magus.ash;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import com.ollicafe.dominationarcana.DominationArcana;

public class AshDust {
	
	//this class is a a collection of particle dust in the world
	
	private double x,y,z;
	private double destX,destY,destZ;
	private World world;
	private boolean exists;
	private DominationArcana plugin;
	private final double speed = 0.25; // speed the ash cloud moves
	private int lifespan;
	
	//probably include a armor stand hitbox to interact
	
	public AshDust(double x, double y, double z, DominationArcana plugin) {
		this.plugin = plugin;
		this.x = x;
		this.y = y;
		this.z = z;
		this.destX = x;
		this.destY = y;
		this.destZ = z;
		this.lifespan = 1000;
	}
	
	public void createCloud() {
		
		
		new BukkitRunnable() {
			

			public void run() {
				while(exists) {
					Random r = new Random();
					//moves the cloud
					move();
					//if idle, set some random movement
					if(x==destX && y==destY && z==destZ) {
						destX = r.nextDouble(-2, 2);
						destY = r.nextDouble(-2, 2);
						destZ = r.nextDouble(-2, 2);
					}
					//create particles at coordinates
					
					
					//check for collisions and create events?
					
					//slowly decay
					if(lifespan <=0) {
						exists = false;
					}
					lifespan--;
				}
				cancel();
			}
		}.runTaskTimer(plugin.getPlugin(plugin.getClass()), 0 ,0);
	}
	
	private void move() {
		if(x != destX) {
			double d = destX - x;
			if(d < speed && d > -speed) {
				x = destX;
			}else {
				if(d < 0) {
					x -= speed;
				}
				if(d > 0) {
					x += speed;
				}
			}
		}
		if(y != destY) {
			double d = destY - y;
			if(d < speed && d > -speed) {
				y = destY;
			}else {
				if(d < 0) {
					y -= speed;
				}
				if(d > 0) {
					y += speed;
				}
			}
		}
		if(z != destZ) {
			double d = destZ - z;
			if(d < speed && d > -speed) {
				z = destZ;
			}else {
				if(d < 0) {
					z -= speed;
				}
				if(d > 0) {
					z += speed;
				}
			}
		}
	}
	
	public void setDestination(double x, double y, double z) {
		
	}
	
	public void setLifespan(int ticks) {
		this.lifespan = ticks;
	}
	
	
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public void remove() {
		exists = false;
		//delete armor stand
	}

}
