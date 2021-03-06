package events;

import com.suna.SunaBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.lang.reflect.Array;

public class HelloEvent extends ListenerAdapter {

    private String phrases[] = {"OlÃ¡!", "Oi?", "Oi!", "Falou comigo?", "Opa! tudo bom?", "Hi ð", "Hi there", "BÃ£um? \uD83E\uDD20"};
    private String talishow[] = {"Mineiro gostoso ð", "ð§ð§ð§", "Pai do Jack", "Puta do Jack", "Puta do Bracinho ð¦¾", "Ã o queijas ð§"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent[] = event.getMessage().getContentRaw().split("\\s+");
        String nameUser = event.getMember().getUser().getName();
        if (messageSent.length == 0) {
            System.out.println("teste");
        }
//        evento hello
        if (messageSent[0].equalsIgnoreCase(SunaBot.prefix + "suna")) {
            EmbedBuilder msg = new EmbedBuilder();
            msg.setColor(Color.decode("#227AFF"));
            int random = (int) Math.floor(Math.random() * phrases.length);
            msg.setDescription("**" + phrases[random] + "**");
            event.getChannel().sendMessage(msg.build()).queue();

        }
//        eventos talishow
        if (messageSent[0].equalsIgnoreCase(SunaBot.prefix + "talisson") | messageSent[0].equalsIgnoreCase("tatim")) {
            EmbedBuilder msg = new EmbedBuilder();
            msg.setColor(Color.decode("#227AFF"));
            int random = (int) Math.floor(Math.random() * talishow.length);
            msg.setDescription("**" + talishow[random] + "**");
            event.getChannel().sendMessage(msg.build()).queue();
            ;
        }
    }
}
