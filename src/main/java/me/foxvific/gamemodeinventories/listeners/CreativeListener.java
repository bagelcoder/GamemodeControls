package me.foxvific.gamemodeinventories.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CreativeListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (player.getGameMode() == GameMode.CREATIVE) {
            if (block.getType() == Material.CHEST || block.getType() == Material.FURNACE) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }
}
