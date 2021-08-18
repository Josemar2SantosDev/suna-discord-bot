package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class ClearEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("limpar")) {
            if (args.length < 2) {
                EmbedBuilder msg = new EmbedBuilder();
                msg.setColor(Color.decode("#227AFF"));
                msg.setTitle("Posso limpar o chat? 🧹");
                msg.setDescription("Comando: **Limpar [número de msgs]**");
                event.getChannel().sendMessage(msg.build()).queue();

            } else {
                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
//                    sucess embed
                    EmbedBuilder msgSucess = new EmbedBuilder();
                    msgSucess.setColor(Color.decode("#7fff7f"));
                    msgSucess.setTitle("Limpinho ✨");
                    msgSucess.setDescription(args[1] + " mensagens foram deletadas.");
                    event.getChannel().sendMessage(msgSucess.build()).queue();
                } catch (IllegalArgumentException e) {
//                    error catch
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit") |
                            e.toString().startsWith("java.lang.IllegalArgumentException: Must provide at least 2 or at most 100 messages")) {
                        EmbedBuilder msgErro = new EmbedBuilder();
                        msgErro.setColor(Color.decode("#CC5547"));
                        msgErro.setTitle("Algo deu errado ... 🤨");
                        msgErro.setDescription("Só posso apagar entre 2 a 100 mensagens.");
                        event.getChannel().sendMessage(msgErro.build()).queue();
                    }
//                    TODO 1. realizar testes;
//                    TODO 2. terminar de ver o video no ytb;
//
//                    EmbedBuilder msgErro = new EmbedBuilder();
//                    msgErro.setColor(Color.decode("#EEC7C3"));
//                    msgErro.setTitle("Algo deu errado ... 😢");
//                    msgErro.setDescription("Só posso deletar entre 1 a 100 mensagens!");
//                    event.getChannel().sendMessage(msgErro.build()).queue();

                }
            }
        }
    }
}
