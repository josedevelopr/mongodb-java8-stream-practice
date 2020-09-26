package com.restaurant.app.repository;

import com.restaurant.app.models.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, String>
{
    List<Restaurant> findAll();
}
