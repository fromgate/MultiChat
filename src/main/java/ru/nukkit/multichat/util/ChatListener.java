package ru.nukkit.multichat.util;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multipass.event.PermissionsUpdateEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 19.05.2016.
 */
public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onChat(PlayerChatEvent event) {
        Message.debugMessage("Source format: " + event.getFormat());
        event.setFormat(Util.getChatFormat(event.getPlayer()));
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (MultiChat.getCfg().nametagEnabled) {
            Util.setNameTag(event.getPlayer(), Util.getNametag(event.getPlayer()));
            Message.debugMessage("setNameTag", Util.getNametag(event.getPlayer()));
        }
        if (MultiChat.getCfg().displayNameEnable) {
            Util.setDisplayName(event.getPlayer(), Util.getDisplayName (player));
        } else {
            player.setDisplayName(player.getName());
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPermission(PermissionsUpdateEvent event) {
        if (!MultiChat.getCfg().nametagEnabled && !MultiChat.getCfg().displayNameEnable) return;
        List<Player> players = new ArrayList<>();
        if (event.isMassUpdate()) {
            players.addAll(Server.getInstance().getOnlinePlayers().values());
        } else {
            Player player = Server.getInstance().getPlayerExact(event.getUser());
            if (player != null) players.add(player);
        }
        Message.debugMessage("setNameTag", event.isMassUpdate() ? "all" : event.getUser());
        players.forEach(player -> {
            if (MultiChat.getCfg().nametagEnabled){
                Util.setNameTag(player, Util.getNametag(player));
            }
            if (MultiChat.getCfg().displayNameEnable){
                Util.setDisplayName(player, Util.getNametag(player));
            }
        });
    }
}
