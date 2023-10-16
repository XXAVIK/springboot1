package com.kata.springboot1.dao;

import com.kata.springboot1.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
        System.out.println("Создан - " + user);

    }

    @Override
    public void edit(User updatedUser) {
        entityManager.merge(updatedUser);
        System.out.println("Изменен - " + updatedUser);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(userById(id));
        System.out.println("Удален юзер");
    }

    @Override
    public User userById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("select u FROM User u", User.class).getResultList();
    }

}
