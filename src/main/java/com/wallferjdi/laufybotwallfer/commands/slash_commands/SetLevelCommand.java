package com.wallferjdi.laufybotwallfer.commands.slash_commands;

import com.wallferjdi.laufybotwallfer.commands.AbstractCommandData;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SetLevelCommand extends AbstractCommandData {


    public SetLevelCommand() {

            setName("set_level");
            setDescription("set level to user");
             List<OptionData> optionData = new ArrayList<>();
             optionData.add(new OptionData(OptionType.USER,"user","choose user",true));
             optionData.add(new OptionData(OptionType.INTEGER,"count","write int count",true));
            setOptionData(optionData);
            setCommand(Commands.slash(getName(),getDescription()).addOptions(getOptionData()));
            System.out.println(getName());

    }


}
