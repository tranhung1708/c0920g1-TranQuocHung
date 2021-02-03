package com.codegym.cms.repository.impl;

import com.codegym.cms.model.Role;
import com.codegym.cms.repository.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class RoleRepositryImpl implements RoleRepository {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = em.createQuery("select r from Role r",Role.class);
        return query.getResultList();
    }

    @Override
    public Role findById(Long id) {
        TypedQuery<Role> query = em.createQuery("select r from Role r where r.id =: id", Role.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Role model) {
        if(model.getId() != null){
            em.merge(model);
        }else{
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Role role = findById(id);
        if(role != null) {
            em.remove(role);
        }
    }
}
