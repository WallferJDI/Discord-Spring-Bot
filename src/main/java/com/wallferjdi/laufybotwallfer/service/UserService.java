package com.wallferjdi.laufybotwallfer.service;



import com.wallferjdi.laufybotwallfer.entity.UserData;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public interface UserService {

    List<UserData> getAllUsers();

    void addUser(User user);

    UserData getUserInfo(User user);

    void deleteUser(String id);
}
