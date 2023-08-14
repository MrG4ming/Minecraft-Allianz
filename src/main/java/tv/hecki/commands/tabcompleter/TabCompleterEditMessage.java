package tv.hecki.commands.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompleterEditMessage implements TabCompleter {

    String[] cmds = {"quit", "join"};

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        ArrayList<String> result = new ArrayList<>();

        if(args.length == 1) {
            for (String s : cmds) {
                if(s.startsWith(args[0])) {
                    result.add(s);
                }
            }
        }

        return result;
    }
}
