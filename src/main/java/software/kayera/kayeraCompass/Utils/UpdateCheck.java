package software.kayera.kayeraCompass.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GitHub;
import software.kayera.kayeraCompass.Managers.LanguageManager;

import java.io.IOException;

public class UpdateCheck {

    private static final String REPO_OWNER = "kayeradev";
    private static final String REPO_NAME = "KayeraCompass";

    public static void checkForUpdate() {
        try {
            GitHub github = GitHub.connectAnonymously();
            GHRelease latestRelease = github.getRepository(REPO_OWNER + "/" + REPO_NAME).getLatestRelease();
            String latestVersion = latestRelease.getTagName();

            PluginDescriptionFile pdf = Bukkit.getPluginManager().getPlugin("KayeraCompass").getDescription();
            String currentVersion = pdf.getVersion();

            if (!currentVersion.equals(latestVersion)) {
                String updateMessage = LanguageManager.getMessage("updatecheck").replace("{version}", latestVersion);
                Bukkit.getConsoleSender().sendMessage(updateMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}