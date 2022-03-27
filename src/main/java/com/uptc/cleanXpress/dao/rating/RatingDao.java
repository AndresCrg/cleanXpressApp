package com.uptc.cleanXpress.dao.rating;

import com.uptc.cleanXpress.models.Rating;

import java.util.List;

public interface RatingDao {

    List<Rating> getRatings();

    void deleteRating(String id);

    void registerRating(Rating rating);
}
