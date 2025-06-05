package com.codegym.photooftheday.repository;

import com.codegym.photooftheday.model.Feedback;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class FeedbackRepository implements IFeedbackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addFeedback(Feedback f) {
        f.setCreatedDate(LocalDate.now());
        entityManager.persist(f);
    }

    @Override
    public List<Feedback> getFeedbacksToday() {
        String jpql = "SELECT f FROM Feedback f WHERE f.createdDate = :date";
        return entityManager.createQuery(jpql, Feedback.class)
                .setParameter("date", LocalDate.now())
                .getResultList();
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
        entityManager.merge(f);
    }
}
