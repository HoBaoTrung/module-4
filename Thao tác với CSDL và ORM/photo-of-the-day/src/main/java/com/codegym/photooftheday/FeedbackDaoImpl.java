package com.codegym.photooftheday;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
@Service
public class FeedbackDaoImpl implements FeedbackDao {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFeedback(Feedback f) {
        f.setCreatedDate(LocalDate.now());
        saveOrUpdate(f);
    }

    private <T> void saveOrUpdate(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<Feedback> getFeedbacksToday() {
        String hql = "FROM Feedback WHERE createdDate = :today";
        TypedQuery<Feedback> query = entityManager.createQuery(hql, Feedback.class);
        query.setParameter("today", LocalDate.now());
        return query.getResultList();
    }

    public Feedback findById(int id) {
        String queryStr = "SELECT c FROM Feedback AS c WHERE c.id = :id";
        TypedQuery<Feedback> query = entityManager.createQuery(queryStr, Feedback.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void likeComment(int id) {
        Feedback f = findById(id);
        f.setLikes(f.getLikes() + 1);
        saveOrUpdate(f);
    }
}
