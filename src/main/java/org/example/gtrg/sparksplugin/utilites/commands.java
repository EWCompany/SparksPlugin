package org.example.gtrg.sparksplugin.utilites;

import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.example.gtrg.sparksplugin.SparksPlugin;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {
    private final SparksPlugin plugin;

    public commands(SparksPlugin plugin) {
        this.plugin = plugin;
    }

    public void subtraction_sparks(int a, Player p) throws IOException {
        int amount = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName() + "amount"));
        int int_amount_health = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName() + "health"));
        SparksPlugin var10000 = this.plugin;
        int int_sparks;
        if (SparksPlugin.YamlData.contains(p.getDisplayName() + "health")) {
            var10000 = this.plugin;
            int_sparks = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName()));
            if (!SparksPlugin.YamlData.getString(p.getDisplayName() + "check").equals("false") && SparksPlugin.YamlData.getString(p.getDisplayName() + "check").equals("true")) {
                ++amount;
            }
            plugin.getLogger().info("debug10");
            SparksPlugin.YamlData.set(p.getDisplayName() + "check", "true");
            int_sparks -= a;
            int_amount_health = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName() + "health"));
            p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, amount, false, false, false));
            var10000 = this.plugin;
            SparksPlugin.YamlData.set(p.getDisplayName(), String.valueOf(int_sparks));
            int_amount_health += 2;
            SparksPlugin.YamlData.set(p.getDisplayName() + "health", String.valueOf(int_amount_health));
            var10000 = this.plugin;
            SparksPlugin.YamlData.save(SparksPlugin.Data);
            SparksPlugin.YamlData.set(p.getDisplayName() + "amount", amount);
            SparksPlugin.YamlData.save(SparksPlugin.Data);
        } else {
            var10000 = this.plugin;
            if (!SparksPlugin.YamlData.contains(p.getDisplayName() + "health")) {
                var10000 = this.plugin;
                SparksPlugin.YamlData.set(p.getDisplayName() + "health", "0");
                var10000 = this.plugin;
                int_sparks = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName()));
                int_sparks -= a;
                var10000 = this.plugin;
                SparksPlugin.YamlData.set(p.getDisplayName(), String.valueOf(int_sparks));
                int_amount_health += 2;
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, amount, false, false, false));
                var10000 = this.plugin;
                SparksPlugin.YamlData.set(p.getDisplayName(), String.valueOf(int_sparks));
                var10000 = this.plugin;
                SparksPlugin.YamlData.save(SparksPlugin.Data);
            }
        }

    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings[0].equals("reload")) {
            plugin.getPluginLoader().disablePlugin(plugin);
            plugin.getPluginLoader().enablePlugin(plugin);
            commandSender.sendMessage(translator.translate(plugin.YamlConfig.getString("successful_reload")));
            plugin.getLogger().info(translator.translate(plugin.YamlConfig.getString("successful_reload")));
        } else {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(translator.translate(SparksPlugin.YamlData.getString("only_player_run_command")));
                return true;
            } else if (strings.length >= 1) {
                if (strings[0].equals("buy")) {
                    Player p = ((Player) commandSender).getPlayer();
                    SparksPlugin var10000 = this.plugin;
                    int amount_sparks_int = Integer.parseInt(SparksPlugin.YamlData.getString(p.getDisplayName()));
                    if (amount_sparks_int >= 200) {
                        try {
                            this.subtraction_sparks(Integer.parseInt(plugin.YamlConfig.getString("number_of_sparks_to_buy_hearts")), p);
                        } catch (IOException var8) {
                            throw new RuntimeException(var8);
                        }

                        p.sendMessage(translator.translate(SparksPlugin.YamlConfig.getString("successful_purchase")));
                    } else {
                        p.sendMessage(translator.translate(SparksPlugin.YamlConfig.getString("not_enough_sparks")));
                    }
                } else if (strings[0].equals("set") && strings.length < 2) {
                    commandSender.sendMessage(translator.translate(SparksPlugin.YamlConfig.getString("not_complete_set_of_arguments")));
                }

                return true;
            } else {
                return true;
            }
        }
        return true;
    }
}