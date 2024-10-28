package org.example.gtrg.sparksplugin.utilites;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.example.gtrg.sparksplugin.SparksPlugin;
import org.jetbrains.annotations.NotNull;

public class placeholder_api_worker extends PlaceholderExpansion {
    private SparksPlugin plugin;

    public placeholder_api_worker(SparksPlugin plugin) {
        this.plugin = plugin;
    }

    @NotNull
    public String getIdentifier() {
        return "sparkplugin";
    }

    @NotNull
    public String getAuthor() {
        return "";
    }

    @NotNull
    public String getVersion() {
        return "1.0";
    }

    @NotNull
    public String onPlaceholderRequest(Player p, String params) {
        if (p == null) {
            return "";
        } else {
            SparksPlugin var10000;
            if (params.equals("amount")) {
                var10000 = this.plugin;
                if (SparksPlugin.YamlData.contains(p.getDisplayName())) {
                    var10000 = this.plugin;
                    return SparksPlugin.YamlData.getString(p.getDisplayName());
                }
            } else if (params.equals("health")) {
                var10000 = this.plugin;
                if (SparksPlugin.YamlData.contains(p.getDisplayName() + "health")) {
                    var10000 = this.plugin;
                    return SparksPlugin.YamlData.getString(p.getDisplayName() + "health");
                }
            }

            return "";
        }
    }

    @NotNull
    public boolean canRegister() {
        return true;
    }

    @NotNull
    public boolean persist() {
        return true;
    }
}