package tv.hecki.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    public static String QuitMsg = "${name} ist weg.de";

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        String msg = QuitMsg.replace("${name}", player.getName());

        TextComponent comp = Component.text(msg, TextColor.color(255, 255, 85));

        e.quitMessage(comp);
    }

}
