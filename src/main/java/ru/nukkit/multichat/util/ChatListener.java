package ru.nukkit.multichat.util;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multipass.Multipass;

/**
 * Created by Igor on 19.05.2016.
 */
public class ChatListener implements Listener{

    @EventHandler (priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onChat (PlayerChatEvent event){
        Message.debugMessage("Source format: "+event.getFormat());
        event.setFormat(getFormat(event.getPlayer()));
    }

    public String getFormat(Player player){

        String format = new String (MultiChat.getCfg().chatFormat);
        format = format.replace("%prefix%",Multipass.getPrefix(player));
        format = format.replace("%suffix%",Multipass.getSuffix(player));
        return TextFormat.colorize(format.trim());
    }

}
