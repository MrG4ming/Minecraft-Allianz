package tv.hecki;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tv.hecki.commands.CommandEditMessage;
import tv.hecki.commands.tabcompleter.TabCompleterEditMessage;
import tv.hecki.listener.PlayerJoinListener;
import tv.hecki.listener.PlayerQuitListener;

public final class Allianz extends JavaPlugin {

    private static Allianz instance;


    public static final TextComponent PREFIX = Component.text(
            "[", TextColor.color(170, 170, 170)
    ).append(Component.text(
            "Allianz", TextColor.color(85, 255, 255)
    ).append(Component.text(
            "] ", TextColor.color(170, 170, 170)
    )));

    public static FileConfiguration Config;

    private static PluginManager pm;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        Config = this.getConfig();

        String joinMsg = Config.getString("joinMsg");
        String quitMsg = Config.getString("quitMsg");


        PlayerJoinListener.JoinMsg = joinMsg != null ? joinMsg : PlayerJoinListener.JoinMsg;
        PlayerQuitListener.QuitMsg = quitMsg != null ? quitMsg : PlayerQuitListener.QuitMsg;

        getCommand("editmsg").setExecutor(new CommandEditMessage());
        getCommand("editmsg").setTabCompleter(new TabCompleterEditMessage());


        pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);



        System.out.println("Allianz plugin enabled successfully.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Allianz getPlugin() {
        return instance;
    }
}
