package org.example.dao;

import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private EntityManager em = emf.createEntityManager();

    public void saveUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User getUser(long id) {
        return em.find(User.class, id);
    }

    public void removeUser(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public List<User> getAllUsers() {
        //Query q = em.createQuery("SELECT u FROM User u");
        Query q = em.createNamedQuery("User.findAll", User.class);
        return q.getResultList();
    }

    public List<User> getAllUserCity(String city) {
        Query q = em.createNamedQuery("User.findAllCity", User.class);
        q.setParameter("city", city);
        return q.getResultList();
    }
}
