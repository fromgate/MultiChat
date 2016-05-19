package ru.nukkit.multichat.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multichat.util.Message;

import static cn.nukkit.permission.BanEntry.format;

/**
 * Created by Igor on 19.05.2016.
 */

@CmdDefine(command = "chat",  alias = "multichat", subCommands = "help", permission = "multichat.config", description = Message.CHAT_HELP )
public class ChatHelp extends Cmd {
    @Override
    public boolean execute(CommandSender sender, Player player, String[] args) {
        Message.CHAT_HELP.print(sender);
        Message.CHAT_RELOAD.print(sender);
        Message.CHAT_SET.print(sender);
        Message.CHAT_HELP_CURRENT.print(sender, MultiChat.getCfg().chatFormat);
        sender.sendMessage(TextFormat.colorize(format).replace("{%0}","Leeloo").replace("{%1}","Big bada boom!"));
        return true;
    }
}
