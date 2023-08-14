package tv.hecki.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import tv.hecki.Allianz;
import tv.hecki.listener.PlayerJoinListener;
import tv.hecki.listener.PlayerQuitListener;

public class CommandEditMessage implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.isOp()) {
            String msg = "";
            switch(args[0]) {
                case "quit":
                    for(int i = 1; i < args.length; i++) {
                        msg += args[i] + " ";
                        Allianz.Config.set("quitMsg", msg);
                        Allianz.getPlugin().saveConfig();
                        PlayerQuitListener.QuitMsg = msg;
                    }
                    break;
                case "join":
                    for(int i = 1; i < args.length; i++) {
                        msg += args[i] + " ";
                        Allianz.Config.set("joinMsg", msg);
                        Allianz.getPlugin().saveConfig();
                        PlayerJoinListener.JoinMsg = msg;
                    }
                    break;
            }

            return true;
        }
        return false;
    }
}
