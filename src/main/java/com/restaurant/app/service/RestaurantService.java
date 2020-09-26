package com.restaurant.app.service;

import com.restaurant.app.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService
{
    List<Map<String, String>> getNameBoroughAndCuisine();
    List<Restaurant> findAll();
}
