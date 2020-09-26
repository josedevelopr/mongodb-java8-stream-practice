package com.restaurant.app.service;

import com.restaurant.app.models.Restaurant;
import com.restaurant.app.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService
{   private static final Logger log = LoggerFactory.getLogger(RestaurantServiceImpl.class);
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Map<String,String>> getNameBoroughAndCuisine()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                    .stream()
                    .limit(5)
                    .peek(r->log.info(r.toString()))
                    .map((r)->{
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        map.put("borough",r.getBorough());
                        map.put("cuisine",r.getCuisine());
                        return map;
                    }).collect(Collectors.toList());
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

}
