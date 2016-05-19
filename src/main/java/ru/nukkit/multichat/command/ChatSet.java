package ru.nukkit.multichat.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import ru.nukkit.multichat.MultiChat;
import ru.nukkit.multichat.util.Message;

/**
 * Created by Igor on 19.05.2016.
 */

@CmdDefine(command = "chat", alias = "multichat", subCommands = "set", permission = "multichat.config", description = Message.CHAT_SET, allowConsole = true)
public class ChatSet extends Cmd {
    @Override
    public boolean execute(CommandSender sender, Player player, String[] args) {
        String format = join(args);
        if (!format.contains("{%0}")&&!format.contains("{%1}")) return Message.CHAT_FAILFORMAT.print(sender);
        MultiChat.getCfg().chatFormat = format;
        MultiChat.getCfg().save();
        Message.CHAT_SET_OK.print(sender);
        sender.sendMessage(TextFormat.colorize(format).replace("{%0}","Leeloo").replace("{%1}","Big bada boom!"));
        return true;
    }


    private String join (String [] args){
        if (args.length<2) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1;i<args.length;i++){
            if (sb.length()>0) sb.append(" ");
            sb.append(args[i]);
        }
        return sb.toString();
    }
}
