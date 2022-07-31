package com.wallferjdi.laufybotwallfer.controller;


import com.wallferjdi.laufybotwallfer.commands.slash_commands.GetAllUsersCommand;
import com.wallferjdi.laufybotwallfer.commands.slash_commands.ResetCommand;
import com.wallferjdi.laufybotwallfer.commands.slash_commands.SetExpCommand;
import com.wallferjdi.laufybotwallfer.commands.slash_commands.SetLevelCommand;
import com.wallferjdi.laufybotwallfer.entity.UserData;
import com.wallferjdi.laufybotwallfer.service.UserServiceImpl;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CommandController extends ListenerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResetCommand resetCommand ;

    @Autowired
    private GetAllUsersCommand getAllUsersCommand;

    @Autowired
    private SetLevelCommand setLevelCommand;

    @Autowired
    private SetExpCommand setExpCommand;

    public CommandController() {
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {


        String eventMessage= event.getName();
        User eventUser = event.getUser();
        String[] splitedCommands = eventMessage.split("_");

       if(eventMessage.equals(resetCommand.getName())){
            eventUser = event.getOption(resetCommand.getOptionData().get(1).getName()).getAsUser();
             userService.deleteUser(eventUser.getId());
            event.reply("Success delete "+eventUser).queue();

        }else if(eventMessage.equals(getAllUsersCommand.getName())) {
            event.reply(userService.getAllUsers().toString()).queue();

        }else if(splitedCommands[0].equals("set")){
            eventUser = event.getOption("user").getAsUser();
            int count = event.getOption("count").getAsInt();
            UserData userData = userService.getUserInfo(eventUser);
            if(eventMessage.equals(setLevelCommand.getName())){

            userData.setLvl(count);
            userService.addUser(userData);
            event.reply( userService.getAllUsers().toString()).queue();

             }else if(eventMessage.equals(setExpCommand.getName())){
            userData.setExp(count);
            userService.addUser(userData);
            event.reply( userService.getAllUsers().toString()).queue();
             }
        }




    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> command = new ArrayList<>();
        command.add(resetCommand.getCommand());
        command.add(Commands.slash(getAllUsersCommand.getName(), getAllUsersCommand.getDescription()));
        command.add(setLevelCommand.getCommand());
        command.add(setExpCommand.getCommand());

        event.getGuild().updateCommands().addCommands(command).queue();

    }
}
