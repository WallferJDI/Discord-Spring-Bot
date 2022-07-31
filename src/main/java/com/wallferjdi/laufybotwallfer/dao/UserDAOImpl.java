package com.wallferjdi.laufybotwallfer.dao;


import com.wallferjdi.laufybotwallfer.entity.UserData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    public UserDAOImpl() {
        System.out.println("CREADTED");
    }


    @Autowired
    private EntityManager entityManager;



    @Override
    public List<UserData> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from UserData", UserData.class).getResultList();
    }

    @Override
    public void addUser(UserData userData) {
        System.out.println(entityManager);
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userData);
    }

    @Override
    public UserData getUserInfo(String id) {

        Session session = entityManager.unwrap(Session.class);

        return session.get(UserData.class,id);
    }

    @Override
    public void deleteUser(String id) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from UserData where id =: id").setParameter("id",id).executeUpdate();
    }
}
