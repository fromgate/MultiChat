package ru.nukkit.multichat.util;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import ru.nukkit.multichat.MultiChat;

public class Cfg {

    public String language="default";

    public boolean saveLanguage = false;

    public boolean debugMode = false;

    public String chatFormat = "&a%prefix%&6%player%&e: %message%";

    public boolean nametagEnabled = true;

    public String nametagFormat = "&a%prefix%&6%player%";

    public ConfigSection customGroups = new ConfigSection();

    public void load(){
        MultiChat.getPlugin().reloadConfig();
        Config cfg = MultiChat.getPlugin().getConfig();
        language=cfg.getString("general.language", "default");
        saveLanguage = cfg.getBoolean("general.language-save",false);
        debugMode = cfg.getBoolean("general.debug", false);
        chatFormat = cfg.getString ("chat.format", "&a%prefix%&6%player%&e: %message%");
        nametagEnabled = cfg.getBoolean ("name-tag.enable", true);
        nametagFormat = cfg.getString ("name-tag.format", "&a%prefix%&6%player%");
        customGroups = cfg.getSection("group-format");
    }

    public void save(){
        Config cfg = MultiChat.getPlugin().getConfig();
        cfg.set("general.language", language);
        cfg.set("general.language-save",saveLanguage);
        cfg.set("general.debug", debugMode);
        cfg.set("chat.format", chatFormat);
        cfg.set("name-tag.enable", nametagEnabled);
        cfg.set ("name-tag.format", nametagFormat);
        cfg.set("group-format",customGroups);
        MultiChat.getPlugin().saveConfig();
    }

}
