package com.wallferjdi.laufybotwallfer.configuration;

import com.wallferjdi.laufybotwallfer.controller.CommandController;
import com.wallferjdi.laufybotwallfer.dao.UserDAOImpl;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;


@Component
public class BotConfig {


    @Autowired
    private CommandController commandController;

    @Value("${discord.bot.token}")
    private String botToken;



    @PostConstruct
    public JDA jdaBot() throws LoginException {
        System.out.println("WORK");
        return  JDABuilder.createDefault(botToken).addEventListeners(commandController).build();
    }


}
