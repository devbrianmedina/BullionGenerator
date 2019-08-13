package brianmedina.bulliongenerator.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.Plugin;

public class BullionCommands extends Command implements PluginIdentifiableCommand {

    public BullionCommands() {
        super("bullion");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(sender.isOp() || sender.hasPermission("brianmedina2612.bullion.generator.cmd")){
            switch (args[0].toLowerCase()){
                case "list":
                    sender.sendMessage("bedrock");
                    sender.sendMessage("gold");
                    sender.sendMessage("iron");
                    sender.sendMessage("coal");
                    sender.sendMessage("lazuli");
                    sender.sendMessage("diamond");
                    sender.sendMessage("redstone");
                    sender.sendMessage("quartz");
                    return true;
                case "give":
                    if(args.length == 3){
                        String type = args[1];
                        String pname = args[2];
                        for(Player p : sender.getServer().getOnlinePlayers().values()){
                            if(p.getName().equals(pname)){
                                if(type.equals("bedrock")){
                                    p.getInventory().addItem(Item.get(Item.BEDROCK));
                                } else if(type.equals("gold")){
                                    p.getInventory().addItem(Item.get(Item.GOLD_ORE));
                                } else if(type.equals("iron")){
                                    p.getInventory().addItem(Item.get(Item.IRON_ORE));
                                } else if(type.equals("coal")){
                                    p.getInventory().addItem(Item.get(Item.COAL_ORE));
                                } else if(type.equals("lazuli")){
                                    p.getInventory().addItem(Item.get(Item.LAPIS_ORE));
                                } else if(type.equals("diamond")){
                                    p.getInventory().addItem(Item.get(Item.DIAMOND_ORE));
                                } else if(type.equals("redstone")){
                                    p.getInventory().addItem(Item.get(Item.REDSTONE_ORE));
                                } else if(type.equals("quartz")){
                                    p.getInventory().addItem(Item.get(Item.QUARTZ_ORE));
                                }
                                break;
                            }
                        }
                    }
                    return true;
                default:
                    sender.sendMessage("COMMANDS");
                    sender.sendMessage("/bullion list");
                    sender.sendMessage("/bullion give <type> <player_name>");
                    return true;
            }
        }
        return false;
    }

    @Override
    public Plugin getPlugin() {
        return null;
    }
}
