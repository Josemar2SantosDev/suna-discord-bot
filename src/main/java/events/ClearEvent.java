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

//                msg sucess;
                EmbedBuilder msgSucess = new EmbedBuilder();
                msgSucess.setTitle("Limpinho ✨");
                msgSucess.setDescription("Deletei" +args[1] + "para você.");
                event.getChannel().sendMessage(msg.build()).queue();
            } else {
                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit") |
                            e.toString().startsWith("java.lang.IllegalArgumentException: Must provide at least 2 or at most 100 messages")) {
                        EmbedBuilder msgErro = new EmbedBuilder();
                        msgErro.setColor(Color.decode("#CC5547"));
                        msgErro.setTitle("Algo deu errado ... 🤨");
                        msgErro.setDescription("Só posso apagar entre 2 a 100 mensagens.");
                        event.getChannel().sendMessage(msgErro.build()).queue();
                    }
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
