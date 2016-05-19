package ru.nukkit.multichat.util;

import cn.nukkit.utils.SimpleConfig;
import ru.nukkit.multichat.MultiChat;

public class Cfg extends SimpleConfig {

    @Path("general.language")
    public String language="default";

    @Path("general.language-save")
    public boolean saveLanguage = false;

    @Path("general.debug")
    public boolean debugMode = false;

    @Path("chat.format")
    public String chatFormat = "&a%prefix% &6{%0}&e: {%1}";

    public Cfg() {
        super(MultiChat.getPlugin());
    }
}
