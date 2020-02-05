package discord.commands;

import discord.DiscordApp;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sudoku.logic.HackySudokuMaker;
import sudoku.logic.discord.RunGameInDiscord;
import sudoku.model.Grid;


public class SudokuEvent extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentRaw().toLowerCase();
        String prefix = DiscordApp.prefix;

        if(msg.startsWith(prefix + "sd")){
            channel.sendMessage("Starting game...").queue();
            createGame(event);
        }
    }

    // CREATES sudoku game stuff and runs it
    public void createGame(GuildMessageReceivedEvent event){
        String preset = HackySudokuMaker.createPuzzle();
        Grid grid = new Grid(9);
        RunGameInDiscord game = new RunGameInDiscord(grid, preset, event);
        game.runGame();
    }
}
