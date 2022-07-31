package com.wallferjdi.laufybotwallfer.entity;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class UserData {

    @Id
    @Column
    private String id;

    @Column
    private String name;
    @Column
    private long messages;

    @Column
    private long voice;

    @Column
    private int lvl;

    @Column
    private int exp;

    public UserData() {
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserData(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMessages() {
        return messages;
    }

    public void setMessages(Long messages) {
        this.messages = messages;
    }

    public long getVoice() {
        return voice;
    }

    public void setVoice(int minutes) {
        this.voice = minutes;
    }

    @Override
    public String toString() {
        return "\n"+
                "User  info \n{" +
                ", Name='" + name + '\n' +
                "Id ='" + id + '\'' +
                ", Messages Count=" + messages +
                ", Voice time =" + voice +
                ", lvl=" + lvl +
                ", exp=" + exp +
                "} \n";
    }
}
