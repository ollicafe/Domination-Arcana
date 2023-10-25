package com.ollicafe.dominationarcana.arcane.alchemyst.iron;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.entity.EntityType;

import net.minecraft.world.entity.animal.EntityIronGolem;

public class IronSuit extends EntityIronGolem{

	public IronSuit(Location loc) {
		super(EntityType.IRON_GOLEM, ((CraftWorld) loc.getWorld()).getHandle());
		
	}
	
	

	//this class is the custom iron golem
}
