package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

    private String phrases[] = {"Olá!", "Oi?", "Oi!", "Falou comigo?", "Opa! tudo bom?", "Hi 😀", "Hi there", "Bãum? \uD83E\uDD20"};
    private String talishow[] = {"Mineiro gostoso 😋", "🧀🧀🧀", "Pai do Jack", "Puta do Jack", "Puta do Bracinho 🦾", "É o queijas 🧀"};

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent[] = event.getMessage().getContentRaw().split(" ");
        String nameUser = event.getMember().getUser().getName();

//        evento hello
        if (messageSent[0].equalsIgnoreCase("suna")) {
            int random = (int) Math.floor(Math.random() * phrases.length);
            event.getChannel().sendMessage(phrases[random]).queue();
        }
//        eventos talishow
        if (messageSent[0].equalsIgnoreCase("talisson") | messageSent[0].equalsIgnoreCase("tatim")) {
            int random = (int) Math.floor(Math.random() * talishow.length);
            event.getChannel().sendMessage(talishow[random]).queue();
        }
    }
}
