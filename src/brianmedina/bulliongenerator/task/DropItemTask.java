package brianmedina.bulliongenerator.task;


import brianmedina.bulliongenerator.Main;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;

import java.io.File;

public class DropItemTask extends Task {

    private Main owner;

    public DropItemTask(Main main){
        this.owner = main;
    }

    @Override
    public void onRun(int tick) {
        for(Level level : owner.getServer().getLevels().values()){
            for(Player p : level.getPlayers().values()){
                if((new File(owner.getDataFolder() + "/players/" + p.getName() + ".yml")).exists()){
                    Config config = new Config(owner.getDataFolder() + "/players/" + p.getName() + ".yml", Config.YAML);
                    int count = config.getInt("count");
                    for(int i = 1; i < count + 1; i++){
                        int x = config.getInt("num" + i + ".x");
                        int y = config.getInt("num" + i + ".y");
                        int z = config.getInt("num" + i + ".z");
                        int time = config.getInt("num" + i + ".time");
                        time++;
                        config.set("num" + i + ".time", time);
                        config.save();
                        Block block = level.getBlock(x, y, z);
                        boolean enable = config.getBoolean("num" + i + ".enable");
                        if(enable && time > 179){
                            if(block.getId() == Block.IRON_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.IRON_INGOT));
                            }
                            if(block.getId() == Block.GOLD_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.GOLD_INGOT));
                            }
                            if(block.getId() == Block.COAL_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.COAL));
                            }
                            if(block.getId() == Block.LAPIS_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.DYE, 4));
                            }
                            if(block.getId() == Block.DIAMOND_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.DIAMOND));
                            }
                            if(block.getId() == Block.REDSTONE_ORE || block.getId() == Block.GLOWING_REDSTONE_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.REDSTONE));
                            }
                            if(block.getId() == Block.QUARTZ_ORE){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.QUARTZ));
                            }
                            if(block.getId() == Block.BEDROCK){
                                level.dropItem(new Vector3(x, y, z), Item.get(Item.BEDROCK));
                            }
                            config.set("num" + i + ".time", 0);
                            config.save();
                        }
                    }
                }
            }
        }
    }
}
