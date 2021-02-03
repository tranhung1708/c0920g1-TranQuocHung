package com.codegym.cms.repository.impl;

import com.codegym.cms.model.User;
import com.codegym.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("select u from User u",User.class);
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id =: id",User.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(User model) {
        if(model != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        User user = findById(id);
        em.remove(user);
    }
}
