package software.kayera.kayeraCompass.Utils;

import org.bukkit.Bukkit;

public class EnableDisableMessages {

    private static final String ASCII_ART =
            " \n"
            + "  _     _____                                     \n"
                    + " | |   / ____|                                    \n"
                    + " | | _| |     ___  _ __ ___  _ __   __ _ ___ ___ \n"
                    + " | |/ / |    / _ \\| '_ ` _ \\| '_ \\ / _` / __/ __|\n"
                    + " |   <| |___| (_) | | | | | | |_) | (_| \\__ \\__ \\\n"
                    + " |_|\\_\\\\_____\\___/|_| |_| |_| .__/ \\__,_|___/___/\n"
                    + "                            | |                  \n"
                    + "                            |_|                  "
            + " \n";

    public static void enable(){
        Bukkit.getConsoleSender().sendMessage("§a" + ASCII_ART);
        Bukkit.getConsoleSender().sendMessage("§aPlugin enabled, thanks for using!");
        Bukkit.getConsoleSender().sendMessage("§ahttps://kayera.software/, https://github.com/kayeradev");
        Bukkit.getConsoleSender().sendMessage("§aTrying to load classes:");
    }

    public static void disable(){
        Bukkit.getConsoleSender().sendMessage("§x§f§c§0§3§3§9" + ASCII_ART);
        Bukkit.getConsoleSender().sendMessage("§x§f§c§0§3§3§9Plugin disabled, goodbye!");
        Bukkit.getConsoleSender().sendMessage("§x§f§c§0§3§3§9https://kayera.software/, https://github.com/kayeradev");
    }
}