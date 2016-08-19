package ru.nukkit.multichat.command;


import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multichat.util.Message;
import ru.nukkit.multichat.util.Util;
import ru.nukkit.multipass.Multipass;


@CmdDefine(command = "chat", alias = "multichat", subCommands = {"group|groupformat", "chat|name|tag|nametag", "\\S+"}, permission = "multichat.config", description = Message.CHAT_SET, allowConsole = true)
public class ChatGroup extends Cmd {
    @Override
    public boolean execute(CommandSender sender, Player player, String[] args) {
        String format = Util.join(args, 3);
        String group = args[2];
        if (args[1].equalsIgnoreCase("chat")) {
            if (!(format.contains("{%0}") || format.contains("%player%")) && !(format.contains("{%1}") || format.contains("%message%")))
                return Message.CHAT_FAILFORMAT.print(sender);
            MultiChat.getCfg().customGroups.set(group + ".chat", format);

            Message.CHAT_GROUP_CHAT_OK.print(sender, group, format);
            sender.sendMessage(TextFormat.colorize(format).replace("%player%", "{%0}").replace("%message%", "{%1}").replace("{%0}", "Leeloo").replace("{%1}", "Big bada boom!"));
        } else if (args[1].matches("(?i)name|tag|nametag")){
            if (!format.contains("{%0}") && !format.contains("%player%"))
                return Message.CHAT_FAILTAGFORMAT.print(sender);
            MultiChat.getCfg().customGroups.set(group + ".name-tag", format);
            Message.CHAT_GROUP_TAG_OK.print(sender, group, format);
        } else return false;
        MultiChat.getCfg().save();
        if (!Multipass.isGroupExist(group)) Message.CHAT_GROUP_NOTEXIST.print(sender, group);
        return true;
    }
}
