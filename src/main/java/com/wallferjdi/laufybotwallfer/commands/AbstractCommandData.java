package com.wallferjdi.laufybotwallfer.commands;

import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.List;

public abstract class AbstractCommandData {

    private List<OptionData> optionData ;
    private String name;
    private String description;
    private SlashCommandData command;

    public void setOptionData(List<OptionData> optionData) {
        this.optionData = optionData;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public void setCommand(SlashCommandData slashCommandData) {
        this.command = slashCommandData;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public SlashCommandData getCommand() {
        return command;
    }

    public List<OptionData>  getOptionData() {
        return optionData;
    }
}
