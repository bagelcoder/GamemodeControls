package me.foxvific.gamemodeinventories;

import me.foxvific.gamemodeinventories.listeners.CreativeListener;
import me.foxvific.gamemodeinventories.listeners.GamemodeChange;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeInventories extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new CreativeListener(), this);
        this.getServer().getPluginManager().registerEvents(new GamemodeChange(), this);
    }
}
