package com.ollicafe.dominationarcana.spells;

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
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.ollicafe.dominationarcana.DominationArcana;
import com.ollicafe.dominationarcana.util.BlockUtil;

public class Ash extends Spell{
	
	private BlockUtil blockUtil = new BlockUtil();
	private DominationArcana plugin;
	
	public Ash(DominationArcana plugin) {
		this.plugin = plugin;
		element = Element.ASH;
	}
	
	public void castSpell(Player player, SpellType spellType) {
		if(createEvent(spellType)){//casts spell if event isn't cancelled
			switch(spellType) {
			case RETURN_TO_ASH:
				returnToAsh(player.getLocation());
				break;
			default:
				System.out.println("Spell Type" + '"' + spellType.toString() + '"' +
						" is invalid for the "+ "'" + element.toString() + '"' + " element" );
				break;
			}
			
		}
	}
	
	//Powerful return to ash spell
	public void returnToAsh(Location loc) {
		int radius = 33 + (1* 1);//player level adds to radius

		List<Block> blocks = blockUtil.getNearbyBlocks(loc, radius);
		blockUtil.changeBiome(loc, radius, Biome.BASALT_DELTAS);
		
		new BukkitRunnable() {
			int count = 0;
			Vector movement = null;
			List<FallingBlock> fblocks = new ArrayList<>();
			
			
			int sec = 33 + (1*1);
			
			public void run() {
				if(count >= 20 * sec) {
					
					
					for(FallingBlock b:fblocks) {
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
					int turnAsh = Math.min(r.nextInt(7), r.nextInt(fblocks.size()));
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
		
	}
	
	
	//deals withering damage to entity
	public void witheringTouch(Player player, Entity ent) {
		
	}
	
	

}
