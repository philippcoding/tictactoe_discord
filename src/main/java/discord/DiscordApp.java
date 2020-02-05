package discord;

import discord.commands.Ping;
import discord.commands.SudokuEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordApp {

    public static final String prefix = "*risbot ";

    public static void main(String[] args) {
        String token = "NjYzNzM1NzQ2MDQ5MzQzNTE4.XjsJlQ.HUDaM80UaXAFrAch9JO6sxtPvpw";
        try{
            JDA jda = new JDABuilder(token)
                    .setActivity(Activity.playing("watching fox news"))
                    .addEventListeners(new SudokuEvent())
                    .addEventListeners((new Ping()))
                    .build();
            jda.awaitReady();
            System.out.println("JDA object built, captain!");
        }
        catch (LoginException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
