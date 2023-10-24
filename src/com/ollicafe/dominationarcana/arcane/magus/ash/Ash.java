package com.ollicafe.dominationarcana.arcane.magus.ash;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.arcane.Soul;
import com.ollicafe.dominationarcana.util.BlockUtil;

public class Ash implements Listener{
	
	private BlockUtil blockUtil = new BlockUtil();
	private DominationArcana plugin;
	
	public Ash(DominationArcana plugin) {
		this.plugin = plugin;
	}
	
	
	//Powerful return to ash spell
	public boolean returnToAsh(Soul soul) {
		Location loc = soul.getEntity().getLocation();
		int radius = 33 + (1* 1);//player level adds to radius

		List<Block> blocks = blockUtil.getNearbyBlocks(loc, radius);
		blockUtil.changeBiome(loc, radius, Biome.BASALT_DELTAS);
		
		new BukkitRunnable() {
			int count = 0;
			List<FallingBlock> fblocks = new ArrayList<>();
			
			
			int sec = 33 + (1*1);//duration is 33 sec plus soul lvl
			
			public void run() {
				if(count >= 20 * sec) {//probably should surround this in while loop for is cancelled
					
					
					
					for(FallingBlock b:fblocks) {
						Location locB = b.getLocation();
						turnAsh(locB.getX(),locB.getY(), locB.getZ());
						b.remove();//turns blocks to ash
						
					}
					
					
					cancel();
				}
				
				Random r = new Random();
				int ashes = r.nextInt(13, 33);
				for(int g = 0;g <= ashes;g++) {
					Block blockGround = blocks.get(r.nextInt(blocks.size() - 0) + 0).getLocation().add(0, r.nextInt(1), 0).getBlock();
					if (blockGround.isEmpty()){
						blockGround = blockGround.getLocation().getWorld().getHighestBlockAt(blockGround.getLocation());
					}
					int weight = r.nextInt(3);
					switch(weight) {
					case 0:
						blockGround.setType(Material.GRAVEL);
						break;
					case 1:
						blockGround.setType(Material.STONE);
						break;
					case 2:
						blockGround.setType(Material.BASALT);
						break;
					case 3:
						blockGround.setType(Material.COBBLESTONE);
						break;
					default: 
					}
						
				}
				Block blockAsh = blocks.get(r.nextInt(blocks.size() - 0) + 0);
				
				FallingBlock fblock = loc.getWorld().spawnFallingBlock(blockAsh.getLocation(), blockAsh.getBlockData());
				fblock.setVelocity(fblock.getLocation().toVector().
						subtract(loc.toVector()).multiply(-10).normalize());
				fblock.setGravity(false);
				fblock.setDropItem(false);
				fblock.setHurtEntities(true);
				
				
				fblocks.add(fblock);
				
				if((count % 3) == 0) {
					//remove up to 7 blocks from the list, starting at 0
					//create a list of ash, add ash particles to list.
					int turnAsh = Math.min(r.nextInt(4, 7), r.nextInt(fblocks.size()));
					for(int dust =0; dust < turnAsh; dust++) {
						FallingBlock fb = fblocks.get(0);
						if(fb != null) {
							fb.getLocation();//TODO:create particle 
							
							fb.remove();;
						}
					}
				}
				
				count++;
			}
		}.runTaskTimer(plugin.getPlugin(plugin.getClass()), 0 ,0);
		
		return true;
	}
	
	public boolean pyroclasticSurge(Soul soul) {
		//for now only players can cast:
		if(!soul.isPlayer()) return false;

		Player player = (Player) soul.getEntity();
		new BukkitRunnable() {
			

			Vector dir = player.getEyeLocation().getDirection();
			Location origin = player.getEyeLocation();
			Vector inc = dir.multiply(2);
			Location loc = origin;
			
			public void run() {
				for(int i = 0; i <= 33; i++) {
					loc = loc.add(inc);
					for(int j = 0; j <= 4; j++) {
						/*TNTPrimed tnt = player.getWorld().spawn(loc, TNTPrimed.class);
						tnt.setYield(i+2);
						tnt.setFuseTicks(0);*/
						blockUtil.createExplosion(loc, i+2); // should do the same thing
					}
				}
				
				cancel();
			}
		}.runTaskTimer(plugin.getPlugin(plugin.getClass()), 0 ,0);
		
		return true;
	}
	
	public AshDust turnAsh(Block block) {
		turnAsh(block.getX(), block.getY(), block.getZ());
		
		return null;
	}
	
	public AshDust turnAsh(double d, double e, double f) {
		
		
		
		return null;
	}
	
	
	//deals withering damage to entity
	public void witheringTouch(Player player, Entity ent) {
		
	}
	
	

}
