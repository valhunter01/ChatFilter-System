package me.VAL.chatFilter;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatFilterSystem implements Listener {
    private final ChatFilter plugin;
    public ChatFilterSystem(ChatFilter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage().toLowerCase();
        List<String> bannedWords = plugin.getConfig().getStringList("banned-words");

        for(String word : bannedWords) {
            if(message.contains(word)) {
                String warn = ChatColor.RED + "7Your message wasn't sent because it contains a blacklisted word: " + ChatColor.WHITE + word;
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', warn));
            }
        }
    }
}
