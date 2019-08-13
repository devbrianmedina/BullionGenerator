package brianmedina.bulliongenerator;

import brianmedina.bulliongenerator.commands.BullionCommands;
import brianmedina.bulliongenerator.listener.EventsListener;
import brianmedina.bulliongenerator.task.DropItemTask;
import cn.nukkit.plugin.PluginBase;

import java.io.File;

public class Main extends PluginBase {

    @Override
    public void onEnable(){
        getDataFolder().mkdir();
        (new File(getDataFolder() + "/players/")).mkdir();
        getServer().getPluginManager().registerEvents(new EventsListener(this), this);
        getServer().getScheduler().scheduleRepeatingTask(new DropItemTask(this), 20);
        getServer().getCommandMap().register("bullion", new BullionCommands());
        getLogger().info("§a--- -- ENABLED -- ---");
        getLogger().info("§a   --- TWITTER ---");
        getLogger().info("   §b@§aTheDevBrian");
        getLogger().info("§bhttps://twitter.com/TheDevBrian");
    }
}
