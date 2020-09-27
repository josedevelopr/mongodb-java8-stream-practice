package com.restaurant.app.service;

import com.restaurant.app.models.Restaurant;
import com.restaurant.app.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService
{   private static final Logger log = LoggerFactory.getLogger(RestaurantServiceImpl.class);
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Map<String, String>> getNameBoroughCuisineAndRestaurantId()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .limit(5)
                .peek(r->log.info(r.toString()))
                .map((r)->{
                    Map<String, String> map = new HashMap<>();
                    map.put("restaurant_id",r.getRestaurant_id().toString());
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
    public List<Map<String, String>> getNameBoroughRestaurantIdAndZipCode()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .limit(5)
                .peek(r->log.info(r.toString()))
                .map((r)->{
                    Map<String, String> map = new HashMap<>();
                    map.put("restaurant_id",r.getRestaurant_id().toString());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("zipcode",r.getAddress().getZipcode());
                    return map;
                }).collect(Collectors.toList());
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsBoroughBronx()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                                           .stream()
                                           .filter(r -> r.getBorough().equals("Bronx"))
                                           .limit(5)
                                           .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsBoroughBronxSkippingFive()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> r.getBorough().equals("Bronx"))
                .skip(5)
                .limit(5)
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsGradeScoreMoreNinety()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter
                (   r -> Arrays.stream(r.getGrades())
                               .filter(g -> g.getScore() > 90)
                               .count() > 0
                )
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsGradeScoreMoreEightyAndLessOneHundred()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter
                        (   r -> Arrays.stream(r.getGrades())
                                .filter(g -> g.getScore() > 80 && g.getScore() < 100)
                                .count() > 0
                        )
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsLocateInLatitudeLessThan()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter( r -> Arrays.stream(r.getAddress().getCoord())
                                    .filter(e -> e < -95.754168)
                                    .count() > 0)
                .peek(l -> log.info(l.toString()))
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> !r.getCuisine().equals("American ")&&
                        Arrays.stream(r.getGrades())
                                .filter(g -> g.getScore() > 70)
                                .count() > 0 &&
                        Arrays.stream(r.getAddress().getCoord())
                               .filter(e -> e < -65.754168)
                               .count() > 0
                )
                .peek(l -> log.info(l.toString()))
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> geRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> !r.getCuisine().equals("American ")&&
                        !r.getBorough().equals("Brooklyn ")&&
                        Arrays.stream(r.getGrades())
                                .filter(g -> g.getGrade().equals("A"))
                                .count() > 0
                )
                .sorted(Comparator.comparing(Restaurant::getCuisine).reversed())
                .limit(5)
                .peek(l -> log.info(l.toString()))
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getIdNameWhereNameStartsWithWil()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> r.getName().startsWith("Wil"))
                .peek(r->log.info("Lista : "+r.toString()))
                .map((r)->{
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    return map;
                }).collect(Collectors.toList());
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getIdNameBoroughCuisineWhereNameContainsCes()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> r.getName().endsWith("ces"))
                .peek(r->log.info("Lista : "+r.toString()))
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
