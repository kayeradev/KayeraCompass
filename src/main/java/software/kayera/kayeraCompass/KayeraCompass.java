package software.kayera.kayeraCompass;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitLamp;
import software.kayera.kayeraCompass.Commands.ReloadCommand;
import software.kayera.kayeraCompass.Commands.TrackCommand;
import software.kayera.kayeraCompass.Listeners.CompassListener;
import software.kayera.kayeraCompass.Managers.ConfigManager;
import software.kayera.kayeraCompass.Managers.LanguageManager;
import software.kayera.kayeraCompass.Utils.EnableDisableMessages;
import software.kayera.kayeraCompass.Utils.UpdateCheck;

public final class KayeraCompass extends JavaPlugin {

    @Override
    public void onEnable() {
        EnableDisableMessages.enable();
        var lamp = BukkitLamp.builder(this).build();
        lamp.register(new TrackCommand(getConfig()));
        lamp.register(new ReloadCommand(getConfig()));
        ConfigManager.init(this);
        LanguageManager.init(this, ConfigManager.getConfig());
        getServer().getPluginManager().registerEvents(new CompassListener(this), this);
        Bukkit.getConsoleSender().sendMessage("§aClasses loaded successfully!");
        UpdateCheck.checkForUpdate();
    }

    @Override
    public void onDisable() {
        EnableDisableMessages.disable();
    }
}