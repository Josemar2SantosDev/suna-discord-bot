package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.lang.reflect.Array;

public class HelloEvent extends ListenerAdapter {

    private String phrases[] = {"Olá!", "Oi?", "Oi!", "Falou comigo?", "Opa! tudo bom?", "Hi 😀", "Hi there", "Bãum? \uD83E\uDD20"};
    private String talishow[] = {"Mineiro gostoso 😋", "🧀🧀🧀", "Pai do Jack", "Puta do Jack", "Puta do Bracinho 🦾", "É o queijas 🧀"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent[] = event.getMessage().getContentRaw().split("\\s+");
        String nameUser = event.getMember().getUser().getName();

//        evento hello
        if (messageSent[0].equalsIgnoreCase("suna")) {
            EmbedBuilder msg = new EmbedBuilder();
            msg.setColor(Color.decode("#227AFF"));
            int random = (int) Math.floor(Math.random() * phrases.length);
            msg.setDescription("**"+phrases[random]+"**");
            event.getChannel().sendMessage(msg.build()).queue();

        }
//        eventos talishow
        if (messageSent[0].equalsIgnoreCase("talisson") | messageSent[0].equalsIgnoreCase("tatim")) {
            EmbedBuilder msg = new EmbedBuilder();
            msg.setColor(Color.decode("#227AFF"));
            int random = (int) Math.floor(Math.random() * talishow.length);
            msg.setDescription("**"+talishow[random]+"**");
            event.getChannel().sendMessage(msg.build()).queue();;
        }
    }
}
