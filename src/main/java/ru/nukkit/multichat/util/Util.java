package ru.nukkit.multichat.util;

import cn.nukkit.Player;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multipass.Multipass;

/**
 * Created by Igor on 20.05.2016.
 */
public class Util {

    public static String getChatFormat(Player player){
        return replacePlaceholders(player, getCustomFormat (player));
    }

    public static String getCustomFormat (Player player){
        ConfigSection section = MultiChat.getCfg().customGroups;
        for (String key : section.getKeys(false)){
            if (!Multipass.isInGroup(player, key)) continue;
            String value = section.getString(key+".chat", "");
            if (!value.isEmpty()) return value;
        }
        return MultiChat.getCfg().chatFormat;
    }

    public static String getCustomNameTag (Player player){
        ConfigSection section = MultiChat.getCfg().customGroups;
        for (String key : section.getKeys(false)){
            if (!Multipass.isInGroup(player, key)) continue;
            String value = section.getString(key+".name-tag", "");
            if (!value.isEmpty()) return value;
        }
        return MultiChat.getCfg().nametagFormat;
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
        format = format.replace("%world%",player.getLevel().getName());
        return TextFormat.colorize(format).trim();
    }

    public static String join (String [] args, int num){
        if (args.length<=num) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = num;i<args.length;i++){
            if (sb.length()>0) sb.append(" ");
            sb.append(args[i]);
        }
        return sb.toString();
    }
}
