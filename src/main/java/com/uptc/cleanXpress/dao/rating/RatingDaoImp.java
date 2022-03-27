package com.uptc.cleanXpress.dao.rating;

import com.uptc.cleanXpress.models.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RatingDaoImp implements RatingDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rating> getRatings() {
        String query = "FROM Rating";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteRating(String id) {
        Rating rating = entityManager.find(Rating.class, id);
        entityManager.remove(rating);
    }

    @Override
    public void registerRating(Rating rating) {
        entityManager.persist(rating);
    }
}
