package ru.nukkit.multichat.util;

import cn.nukkit.Player;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multipass.Multipass;

public class Util {

    public static String getChatFormat(Player player) {
        return replacePlaceholders(player, getCustomFormat(player));
    }

    public static String getCustomFormat(Player player) {
        return getCusomParam(player, true);
    }

    public static String getCustomNameTag(Player player) {
        return getCusomParam(player, false);
    }

    private static String getCusomParam(Player player, boolean getFormat) {
        String param = getFormat ? ".chat" : ".name-tag";
        String result = getFormat ? MultiChat.getCfg().chatFormat : MultiChat.getCfg().nametagFormat;
        ConfigSection section = MultiChat.getCfg().customGroups;
        for (String key : section.getKeys(false)) {
            if (isPlayerInGroup(player, key) && section.exists(key + param)) {
                result = section.getString(key + param);
            }
        }
        return result;
    }

    private static boolean isPlayerInGroup(Player player, String group) {
        if (!MultiChat.getCfg().useSubGroup) return Multipass.isInGroup(player, group);
        for (String g : Multipass.getGroups(player))
            if (group.equalsIgnoreCase(g)) return true;
        return false;
    }

    public static String getNametag(Player player) {
        return replacePlaceholders(player, getCustomNameTag(player))
                .replace("{%0}", player.getName()).replace("{%1}", "");
    }

    private static String replacePlaceholders(Player player, String str) {
        String format = new String(str);
        format = format.replace("%prefix%", Multipass.getPrefix(player));
        format = format.replace("%suffix%", Multipass.getSuffix(player));
        format = format.replace("%player%", player.getName()).replace("%message%", "{%1}");
        format = format.replace("%display%", player.getDisplayName()).replace("%message%", "{%1}");
        format = format.replace("%world%", player.getLevel().getName());
        return TextFormat.colorize(format).trim();
    }

    public static String join(String[] args, int num) {
        if (args.length <= num) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = num; i < args.length; i++) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(args[i]);
        }
        return sb.toString();
    }

    public static void setNameTag(Player player, String nameTag) {
        if (nameTag == null || nameTag.isEmpty()) {
            player.setNameTagVisible(false);
        } else {
            player.isNameTagVisible();
            player.setDisplayName(TextFormat.colorize(nameTag));
        }
    }

    public static void setDisplayName(Player player, String nameTag) {
        player.setDisplayName(MultiChat.getCfg().isDisplayNameNoColors ? TextFormat.clean(nameTag) : nameTag);
    }
}
