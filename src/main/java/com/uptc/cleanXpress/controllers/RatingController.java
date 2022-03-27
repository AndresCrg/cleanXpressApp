package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.rating.RatingDao;
import com.uptc.cleanXpress.models.Rating;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    private RatingDao ratingDao;

    @RequestMapping(value = "/api/getRatings", method = RequestMethod.GET)
    public List<Rating> getRatings(){ return ratingDao.getRatings(); }

    @RequestMapping(value = "/api/registerRating", method = RequestMethod.POST)
    public void registerRating(@RequestBody Rating rating){ ratingDao.registerRating(rating);}

    @RequestMapping(value = "/api/getRatings/{id}", method = RequestMethod.DELETE)
    public void deleteRating(@PathVariable String id){ratingDao.deleteRating(id);}
}
