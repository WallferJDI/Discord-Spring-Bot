package com.wallferjdi.laufybotwallfer.commands.slash_commands;

import com.wallferjdi.laufybotwallfer.commands.AbstractCommandData;
import com.wallferjdi.laufybotwallfer.service.UserServiceImpl;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GetAllUsersCommand extends AbstractCommandData {

    public GetAllUsersCommand() {
        setName("get_user_list");
        setDescription("return list of all users");
        setCommand(Commands.slash(getName(),getDescription()));

    }
}
