package ru.nukkit.multichat.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multichat.util.Message;

/**
 * Created by Igor on 19.05.2016.
 */


@CmdDefine(command = "chat", alias = "multichat", subCommands = "reload", permission = "multichat.config", description = Message.CHAT_RELOAD, allowConsole = true)
public class ChatReload extends Cmd {
    public boolean execute(CommandSender sender, Player player, String[] args) {
        MultiChat.getCfg().load();
        return Message.CHAT_RELOADED.print(sender);
    }
}
