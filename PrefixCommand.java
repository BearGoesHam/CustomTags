package com.galasticnetwork.tags;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class PrefixCommand implements CommandExecutor
{

    Main main;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("tag"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;
                if(p.hasPermission("tags.use"))
                {
                    //HashMap<UUID, String> tags = new HashMap<UUID, String>();
                    File tagsFile = new File(main.getDataFolder() + "/tags.yml");
                    FileConfiguration tagsConfig = YamlConfiguration.loadConfiguration(tagsFile);
                    File playerData = new File(main.getDataFolder() + "/players.yml");
                    FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerData);
                    if(args.length == 3 && args[0].equalsIgnoreCase("create"))
                    {
                        String tagName = args[1];
                        String tagContent = args[2];

                        if(tagsConfig.contains(tagName))
                        {
                            p.sendMessage(ChatColor.DARK_AQUA + "[TAGS] This tag already exsists!");
                        } else {
                            p.sendMessage(ChatColor.DARK_AQUA + "[TAGS] You have created the tag: " + tagName);
                            tagsConfig.createSection(tagName);
                            tagsConfig.set(tagName, tagContent);
                        }
                    } else if(args.length == 4 && args[0].equalsIgnoreCase("set"))
                    {

                    }
                } else
                {
                    p.sendMessage(ChatColor.DARK_AQUA + "[TAGS] You do not have permission for this.");
                }
            } else
                {
                    System.out.println("Only players can do this.");
                }
        }



        return false;
    }

}
