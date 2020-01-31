import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class main {

    public static final String prefix = "*risbot";

    public static void main(String[] args) {
        String token = " ";
        try{
            JDA jda = new JDABuilder(token)
                    .setActivity(Activity.playing("watching fox news"))
                    .build();
            jda.awaitReady();
            System.out.println("JDA object built, captain!");
        }
        catch (LoginException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
