package ru.nukkit.multichat;

import cn.nukkit.plugin.PluginBase;
import ru.nukkit.multichat.command.Commander;
import ru.nukkit.multichat.util.Cfg;
import ru.nukkit.multichat.util.ChatListener;
import ru.nukkit.multichat.util.Message;

public class MultiChat extends PluginBase{

    private static MultiChat instance;
    private Cfg cfg;

    public static MultiChat getPlugin(){
        return instance;
    }
    public static Cfg getCfg(){
        return instance.cfg;
    }


    @Override
    public void onEnable(){
        instance = this;
        cfg = new Cfg();
        saveDefaultConfig();
        cfg.load();
        Message.init(this);
        Commander.init(this);
        getServer().getPluginManager().registerEvents(new ChatListener(),this);
    }
}
