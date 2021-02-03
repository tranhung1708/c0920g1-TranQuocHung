package vn.codegym.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.codegym.model.Product;
import vn.codegym.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;


public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;


    @Override
    public List<Product> finAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
            return productList;
        }

    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product finById(int id) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from Product s where s.id = :idProduct", Product.class);
        typedQuery.setParameter("idProduct", id);

        TypedQuery<Product> typedQuery2 =
                BaseRepository.entityManager.createQuery(
                        "select s from Product s where s.id = ?1", Product.class);
        typedQuery2.setParameter(1, id);

        return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Product product = finById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
