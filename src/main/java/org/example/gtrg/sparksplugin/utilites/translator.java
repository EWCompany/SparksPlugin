package org.example.gtrg.sparksplugin.utilites;

import org.bukkit.ChatColor;

public class translator {
    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}