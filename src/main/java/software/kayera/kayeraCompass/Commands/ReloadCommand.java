package software.kayera.kayeraCompass.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;
import software.kayera.kayeraCompass.Managers.ConfigManager;
import software.kayera.kayeraCompass.Managers.LanguageManager;

public class ReloadCommand {

    private final FileConfiguration config;

    public ReloadCommand(FileConfiguration config) {
        this.config = config;
    }

    @Command({"kc reload", "kcompass reload", "kayeracompass reload", "kc rl", "kcompass rl", "kayeracompass rl"})
    public void reloadConfigAndLangFiles(BukkitCommandActor actor) {
        CommandSender commandSender = actor.asPlayer();

        if (commandSender instanceof Player) {
            Player sender = (Player) commandSender;

            if (!sender.hasPermission("kayera.compass.reload")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', LanguageManager.getMessage("no_permission")));
                return;
            }

            ConfigManager.reload();
            LanguageManager.reload();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', LanguageManager.getMessage("config_reloaded")));
        } else {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', LanguageManager.getMessage("only_players")));
        }
    }
}