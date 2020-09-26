package com.restaurant.app.controller;

import com.restaurant.app.models.Restaurant;
import com.restaurant.app.repository.RestaurantRepository;
import com.restaurant.app.service.RestaurantService;
import com.restaurant.app.service.RestaurantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/restaurant")
@CrossOrigin
public class RestaurantController
{
    // Logger
    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository){this.restaurantRepository = restaurantRepository;}

    @GetMapping
    public @ResponseBody
    ResponseEntity getAllRestaurants()
    {   List<Restaurant> lstResultado = restaurantRepository.findAll()
                                                            .stream()
                                                            .limit(5)
                                                            .collect(Collectors.toList());
        log.info(lstResultado.toString());
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio02")
    public @ResponseBody
    ResponseEntity getNameBoroughAndCuisine()
    {   List<Map<String,String>>lstResultado = restaurantService.getNameBoroughAndCuisine();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }
}
