package com.ollicafe.dominationarcana.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;

import net.minecraft.world.level.block.Blocks;

public class BlockUtil {
	
	private PlayerUtil pUtil = new PlayerUtil();
	
	public List<Block> getNearbyTopBlocks(Location loc, int radius){
		List<Block> blocks = new ArrayList<Block>();
		for(int x = loc.getBlockX() - radius; x <= loc.getBlockX() + radius; x++) {
			for(int z = loc.getBlockZ() - radius; z <= loc.getBlockZ() + radius; z++) {
				blocks.add(loc.getWorld().getHighestBlockAt(x,z).getLocation().subtract(0, 0, 0).getBlock());
			}
		}
		
		
		return blocks;
	}
	
	public List<Block> getAllNearbyBlocks(Location loc, int radius){
		List<Block> blocks = new ArrayList<Block>();
		for(int x = loc.getBlockX() - radius; x <= loc.getBlockX() + radius; x++) {
			for(int y = loc.getBlockY() - radius; y <= loc.getBlockY() + radius; y++) {
				for(int z = loc.getBlockZ() - radius; z <= loc.getBlockZ() + radius; z++) {
					blocks.add(loc.getWorld().getBlockAt(x, y, z));
				}
			}
		}
		
		return blocks;
		
	}
	
	public void changeBiome(Location loc, int radius, Biome biome) {
		
		for(int x = loc.getBlockX() - radius; x <= loc.getBlockX() + radius; x++) {
			for(int z = loc.getBlockZ() - radius; z <= loc.getBlockZ() + radius; z++) {
				for(int y = loc.getBlockY() - radius; y <= loc.getBlockY() + radius; y++) {
					loc.getWorld().setBiome(x, y, z, biome);
					
				}
				
			}
		}
		//send update to nearby players for chunk change
		int chunkX = loc.getBlockX()/16,chunkZ = loc.getBlockZ()/16;
		int chunkRadius = (radius/16) + 1;
		
		for(int cX = chunkX - chunkRadius; cX <= chunkX + chunkRadius; cX++) {
			for(int cZ = chunkZ - chunkRadius; cZ <= chunkZ + chunkRadius; cZ++) {
				loc.getWorld().refreshChunk(cX,cZ);
				
			}
		}
	}
	
	public void removeWater(Location loc, int radius) {
		List<Block> blocks = getAllNearbyBlocks(loc, radius);
		blocks.removeIf(b -> (!b.getType().equals(Material.WATER)));
		for(Block b: blocks) {
			if(b.getType().equals(Material.WATER)) {
				b.setType(Material.AIR);
			}
		}
//		//send update to nearby players for chunk change
//		int chunkX = loc.getBlockX()/16,chunkZ = loc.getBlockZ()/16;
//		int chunkRadius = (radius/16) + 1;
//		
//		for(int cX = chunkX - chunkRadius; cX <= chunkX + chunkRadius; cX++) {
//			for(int cZ = chunkZ - chunkRadius; cZ <= chunkZ + chunkRadius; cZ++) {
//				loc.getWorld().refreshChunk(cX,cZ);
//				
//			}
//		}
	}
	
	public void createExplosion(Location loc, int power) {
		TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
		tnt.setYield(power);
		tnt.setFuseTicks(0);
	}
	
	public void createExplosion(Location loc, float power, Entity ent) {
		TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
		tnt.setYield(power);
		tnt.setSource(ent);
		tnt.setFuseTicks(0);
	}
	
	public void createExplosionF(Location loc, float power) {
		TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
		tnt.setYield(power);
		tnt.setIsIncendiary(true);
		tnt.setFuseTicks(0);
	}
	
	public void createExplosionF(Location loc, float power, Entity ent) {
		TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
		tnt.setYield(power);
		tnt.setSource(ent);
		tnt.setIsIncendiary(true);
		tnt.setFuseTicks(0);
	}

}
