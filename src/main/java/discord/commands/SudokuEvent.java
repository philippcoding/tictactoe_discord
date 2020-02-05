package discord.commands;

import discord.DiscordApp;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class SudokuEvent extends ListenerAdapter {
    public void onGuildMessageReceivedEvent(GuildMessageReceivedEvent event){
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentRaw().toLowerCase();
        String prefix = DiscordApp.prefix;

        if(msg.startsWith(prefix + "sd")){
            createGame(author);
        }
    }

    public void createGame(User author){

    }
}
