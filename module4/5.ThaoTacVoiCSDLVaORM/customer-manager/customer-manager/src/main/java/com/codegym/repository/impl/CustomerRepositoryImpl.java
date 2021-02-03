package com.codegym.repository.impl;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from customer s", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public Customer findById(int id) {
                TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from customer s where s.id = :idStudent", Customer.class);
        typedQuery.setParameter("idStudent", id);

        TypedQuery<Customer> typedQuery2 =
                BaseRepository.entityManager.createQuery(
                        "select s from customer s where s.id = ?1", Customer.class);
        typedQuery2.setParameter(1, id);

        return typedQuery.getSingleResult();
//        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void update(Customer product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        Customer product = findById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
