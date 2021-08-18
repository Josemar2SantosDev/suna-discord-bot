package com.suna;

import events.ClearEvent;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class SunaBot {
    public static String prefix = "!";

    public static void main(String[] args) throws Exception {

        JDABuilder sunaBot = JDABuilder.createDefault("ODI3MDEwMzkwOTMxNjY5MDMz.YGUzcg.wMaf6tK4dZWhLub2cUXZSX-o2kI");
        sunaBot.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        sunaBot.setBulkDeleteSplittingEnabled(false);
        sunaBot.setActivity(Activity.playing("Grand Chase"));
        sunaBot.setStatus(OnlineStatus.DO_NOT_DISTURB);

        sunaBot.addEventListeners(new HelloEvent()); // interaçoes
        sunaBot.addEventListeners(new ClearEvent()); //limpar chat
        sunaBot.build();

    }
}
