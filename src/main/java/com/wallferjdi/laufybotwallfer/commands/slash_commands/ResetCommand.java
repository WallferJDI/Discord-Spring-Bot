package com.wallferjdi.laufybotwallfer.commands.slash_commands;

import com.wallferjdi.laufybotwallfer.commands.AbstractCommandData;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResetCommand  extends AbstractCommandData {

    public ResetCommand() {
        setName("reset");
        setDescription("delete user from database");
        List<OptionData> optionDataList = new ArrayList<OptionData>();
        optionDataList.add(new OptionData(OptionType.USER, "user", "choose user", true));
        setOptionData(optionDataList);
        setCommand(Commands.slash(getName(),getDescription()).addOptions(getOptionData()));
        System.out.println(getName());
    }
}
