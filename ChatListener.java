package com.galasticnetwork.tags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatListener implements Listener
{

    FileManager manager;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();

        String msg = e.getMessage();

    e.setCancelled(true);

    e.setMessage(PermissionsEx.getUser(p).getPrefix() + " " + manager.getPrefix(p) + " " + p.getDisplayName() + ": "+ msg);
    }

}
