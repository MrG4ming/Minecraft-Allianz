package tv.hecki.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    public static String JoinMsg = "${name} ist back wie Rücken...";

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        String msg = JoinMsg.replace("${name}", player.getName());

        TextComponent comp = Component.text(msg, TextColor.color(255, 255, 85));
        e.joinMessage(comp);
    }

}
