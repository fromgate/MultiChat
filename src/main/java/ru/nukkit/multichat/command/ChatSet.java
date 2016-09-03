package ru.nukkit.multichat.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multichat.util.Message;
import ru.nukkit.multichat.util.Util;

/**
 * Created by Igor on 19.05.2016.
 */

@CmdDefine(command = "chat", alias = "multichat", subCommands = {"set", "chat|name|tag|nametag"}, permission = "multichat.config", description = Message.CHAT_SET, allowConsole = true)
public class ChatSet extends Cmd {
    @Override
    public boolean execute(CommandSender sender, Player player, String[] args) {
        String format = Util.join(args, 2);
        if (args[1].equals("chat")) {
            if (!(format.contains("{%0}") || format.contains("%player%")) && !(format.contains("{%1}") || format.contains("%message%")))
                return Message.CHAT_FAILFORMAT.print(sender);
            MultiChat.getCfg().chatFormat = format;

            Message.CHAT_SET_OK.print(sender, format);
            sender.sendMessage(TextFormat.colorize(format).replace("%player%", "{%0}").replace("%message%", "{%1}").replace("{%0}", "Leeloo").replace("{%1}", "Big bada boom!"));
        } else if (args[1].matches("(?i)name|tag|nametag")) {
            if (!format.contains("{%0}") && !format.contains("%player%"))
                return Message.CHAT_FAILTAGFORMAT.print(sender);
            MultiChat.getCfg().nametagFormat = format;
            Message.CHAT_SETTAG_OK.print(sender, format);
        } else return false;

        MultiChat.getCfg().save();
        return true;
    }


}
