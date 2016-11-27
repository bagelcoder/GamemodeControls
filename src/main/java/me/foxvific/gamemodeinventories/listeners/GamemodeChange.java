package me.foxvific.gamemodeinventories.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class GamemodeChange implements Listener {

    public HashMap<Player, ItemStack[]> inventory = new HashMap<Player, ItemStack[]>();
    public HashMap<Player, ItemStack[]> armor = new HashMap<Player, ItemStack[]>();

    @EventHandler
    public void onPlayerGamemodeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode gamemode = event.getNewGameMode();

        if (gamemode == GameMode.CREATIVE) {
            inventory.put(player, player.getInventory().getContents());
            armor.put(player, player.getInventory().getArmorContents());
        }

        if (gamemode == GameMode.SURVIVAL) {
            player.getInventory().setContents(inventory.get(player));
            player.getInventory().setArmorContents(armor.get(player));
        }
    }
}
