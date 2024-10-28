package org.example.gtrg.sparksplugin;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.example.gtrg.sparksplugin.utilites.translator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.gtrg.sparksplugin.SparksPlugin.*;

public class Events implements Listener {
    private SparksPlugin plugin;

    public Events(SparksPlugin plugin) {
        this.plugin = plugin;
    }

    public void increaseSparks(int amount, Player p) throws IOException {
        if (!plugin.YamlData.contains(p.getDisplayName())) {
            plugin.YamlData.set(p.getDisplayName(), "0");
            plugin.YamlData.save(Data);
        }

        int int_amount_sparks = Integer.parseInt(plugin.YamlData.getString(p.getDisplayName()));

        int_amount_sparks += amount;

        YamlData.set(p.getDisplayName(), String.valueOf(int_amount_sparks));
        YamlData.save(Data);
    }

    @EventHandler
    public void onBlockBreakDiamondOre(BlockBreakEvent e) throws IOException {
        if (e.getBlock().getType() == Material.DIAMOND_ORE) {
            Player p = e.getPlayer();
            increaseSparks(50, p);
            p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 0.8f, 0.0f);
        }
    }

    @EventHandler
    public void onBlockBreakGoldOre(BlockBreakEvent e) throws IOException {
        if (e.getBlock().getType() == Material.GOLD_ORE) {
            Player p = e.getPlayer();
            increaseSparks(25, p);
        }
    }

    @EventHandler
    public void onBlockBreakIronOre(BlockBreakEvent e) throws IOException {
        if (e.getBlock().getType() == Material.IRON_ORE) {



            Player p = e.getPlayer();
            increaseSparks(15, p);
        }
    }

    @EventHandler
    public void onBlockBreakCoalOre(BlockBreakEvent e) throws IOException {
        if (e.getBlock().getType() == Material.COAL_ORE) {
            Player p = e.getPlayer();
            increaseSparks(5, p);
        }
    }

    @EventHandler
    public void onjoinevent(PlayerJoinEvent e) throws IOException {
        Player p = e.getPlayer();
        if (!YamlData.contains(p.getDisplayName())) {
            YamlData.set(p.getDisplayName() + "check", "false");
            YamlData.set(p.getDisplayName() + "amount", "0");
            YamlData.set(p.getDisplayName() + "health", "0");
            YamlData.set(p.getDisplayName(), "0");
            YamlData.save(Data);
        }
        if (YamlData.getString(p.getDisplayName() + "check").equals("true")) {
            int delay = 100;
            Bukkit.getScheduler().runTaskLater(plugin, () -> {

                Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                    if (!p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, YamlData.getInt(p.getDisplayName() + "amount")));
                    }
                }, 0, 100);
            }, delay);
        }
    }

    @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        int amount = YamlData.getInt(p.getDisplayName() + "amount");
        if (YamlData.getString(p.getDisplayName() + "check").equals("true")) {
            int delay = 25;
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, amount));
            }, delay);
        }
        else {

        }
    }
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e){
        if (e.getItem().getType() == Material.MILK_BUCKET) {
            Player p = e.getPlayer();
            int amount = YamlData.getInt(p.getDisplayName() + "amount");
            if (YamlData.getString(p.getDisplayName() + "check").equals("true")) {
                int delay = 25;
                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, amount));
                }, delay);
            }
            else {

            }
        }
    }
}