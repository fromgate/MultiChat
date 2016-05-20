package ru.nukkit.multichat.util;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multipass.Multipass;

/**
 * Created by Igor on 20.05.2016.
 */
public class Util {

    public static String getChatFormat(Player player){
        return replacePlaceholders(player, MultiChat.getCfg().chatFormat);
    }

    public static String getNametag(Player player){
        return replacePlaceholders(player, MultiChat.getCfg().nametagFormat)
                .replace("{%0}",player.getName()).replace("{%1}","");
    }

    private static String replacePlaceholders (Player player, String str){
        String format = new String(str);
        format = format.replace("%prefix%", Multipass.getPrefix(player));
        format = format.replace("%suffix%",Multipass.getSuffix(player));
        format = format.replace("%player%","{%0}").replace("%message%","{%1}");
        return TextFormat.colorize(format).trim();
    }
}
