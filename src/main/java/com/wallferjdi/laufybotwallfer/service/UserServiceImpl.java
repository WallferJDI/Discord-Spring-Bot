package com.wallferjdi.laufybotwallfer.service;

import com.wallferjdi.laufybotwallfer.dao.UserDAOImpl;
import com.wallferjdi.laufybotwallfer.entity.UserData;
import net.dv8tion.jda.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{



    private UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
        System.out.println(this.userDAO);
    }

    @Override
    @Transactional
    public List<UserData> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {

        userDAO.addUser(new UserData(user.getId(), user.getName()));
    }
    @Transactional
    public void addUser(UserData userData) {

        userDAO.addUser(userData);
    }

    @Override
    @Transactional
    public UserData getUserInfo(User userDiscrod) {


        UserData userData = userDAO.getUserInfo(userDiscrod.getId());
        if (userData !=null){
            return userData;
        }else {
            System.out.println(userDiscrod.getName());
            addUser(userDiscrod);
            return userDAO.getUserInfo(userDiscrod.getId());
        }
    }

    @Transactional
    public UserData getUserInfo(UserData userData) {


         userData = userDAO.getUserInfo(userData.getId());
        if (userData !=null){
            return userData;
        }else {
            System.out.println(userData.getName());
            addUser(userData);
            return userDAO.getUserInfo(userData.getId());
        }
    }


    @Override
    @Transactional
    public void deleteUser(String id) {
        try {
            userDAO.deleteUser(id);
        }catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }

    }
}
