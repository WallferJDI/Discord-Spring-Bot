package com.wallferjdi.laufybotwallfer.dao;


import com.wallferjdi.laufybotwallfer.entity.UserData;

import java.util.List;

public interface UserDAO {

    List<UserData> getAllUsers();

    void addUser(UserData userData);

    UserData getUserInfo(String id);

    void deleteUser(String id);


}
