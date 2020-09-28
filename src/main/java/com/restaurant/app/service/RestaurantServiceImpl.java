package com.restaurant.app.service;

import com.restaurant.app.models.Restaurant;
import com.restaurant.app.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
    public List<Restaurant> getRestaurantsBoroughBronx()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        lstResultado = restaurantRepository.findAll()
                                           .stream()
                                           .filter(r -> r.getBorough().equals("Bronx"))
                                           .limit(5)
                                           .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Restaurant> getRestaurantsBoroughBronxSkippingFive()
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
    public List<Restaurant> getRestaurantsGradeScoreMoreNinety()
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
    public List<Restaurant> getRestaurantsGradeScoreMoreEightyAndLessOneHundred()
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
    public List<Restaurant> getRestaurantsLocateInLatitudeLessThan()
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
    public List<Restaurant> getRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan()
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
    public List<Restaurant> getRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn()
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
    public List<Map<String, String>> getIdNameBoroughCuisineWhereNameFinishesCes()
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
    public List<Map<String, String>> getIdNameBoroughCuisineWhereNameContainsReg()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> r.getName().contains("Reg"))
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
    public List<Restaurant> getRestaurantsWhereBorouhgBronxCuisineAmericanOrChinese()
    {   List<Restaurant> lstResultado = new ArrayList<>();
        List<String> filter = Arrays.asList("American ","Chinese");
        lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> filter.contains(r.getCuisine()) &&
                             r.getBorough().equals("Bronx")
                )
                .peek(l -> log.info(l.toString()))
                .collect(Collectors.toList());
        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        List<String> filterBorough = Arrays.asList("Staten Island","Queens","Bronx","Brooklyn");
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> filterBorough.contains(r.getBorough()))
                .map((r) -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("cuisine",r.getCuisine());
                    return map;
                }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                                            .stream()
                                            .filter(r -> filterBorough.contains(r.getBorough()))
                                            .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        List<String> filterBorough = Arrays.asList("Staten Island","Queens","Bronx","Brooklyn");
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(r -> !filterBorough.contains(r.getBorough()))
                .map((r) -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("cuisine",r.getCuisine());
                    return map;
                }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(r -> !filterBorough.contains(r.getBorough()))
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereGradeScoreNotMoreThan10()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();

        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> Arrays.stream(r.getGrades())
                                   .noneMatch(g -> g.getScore() > 10)

                )
                .map((r) -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("cuisine",r.getCuisine());
                    return map;
                }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(
                            r -> Arrays.stream(r.getGrades())
                                    .noneMatch(g -> g.getScore() > 10)

                    )
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereCuisineNotAmericanOrChinese()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        List<String> filterCuisine = Arrays.asList("American ","Chinese");
        try
        {   lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> ! filterCuisine.contains(r.getCuisine()) ||
                             r.getName().startsWith("Wil")
                )
                .map((r) -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("cuisine",r.getCuisine());
                    return map;
                }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(
                            r -> ! filterCuisine.contains(r.getCuisine()) ||
                                    r.getName().startsWith("Wil")
                    )
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
        public List<Map<String, String>> getRestaurantsWhereGradeAandScore11AndISODate20140811()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   String sDate1 = "2014-08-11T00:00:00Z";
            Instant instant = Instant.parse(sDate1);
            Date dateToFilter = Date.from(instant);

            lstResultado = restaurantRepository.findAll()
                .stream()
                .filter(
                        r -> Arrays.stream(r.getGrades())
                                   .anyMatch(g -> g.getDate().equals(dateToFilter) &&
                                                  g.getGrade().equals("A") &&
                                                  g.getScore() == 11
                                                  )
                )
                .map((r) -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("_id",r.getId());
                    map.put("name",r.getName());
                    map.put("borough",r.getBorough());
                    map.put("cuisine",r.getCuisine());
                    return map;
                }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(
                            r -> Arrays.stream(r.getGrades())
                                    .anyMatch(g -> g.getGrade().equals("A") &&
                                            g.getScore()==11 &&
                                            g.getDate().equals(dateToFilter))

                    )
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereSecondGradeAandScore9AndISODate20140811()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {   String sDate1 = "2014-08-11T00:00:00Z";
            Instant instant = Instant.parse(sDate1);
            Date dateToFilter = Date.from(instant);

            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter(r -> r.getGrades().length > 1)
                    .filter(
                            r -> r.getGrades()[1].getDate().equals(dateToFilter) &&
                                 r.getGrades()[1].getGrade().equals("A") &&
                                 r.getGrades()[1].getScore() == 9
                    )
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        map.put("borough",r.getBorough());
                        map.put("cuisine",r.getCuisine());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(r -> r.getGrades().length > 1)
                    .filter(
                            r -> r.getGrades()[1].getDate().equals(dateToFilter) &&
                                 r.getGrades()[1].getGrade().equals("A") &&
                                 r.getGrades()[1].getScore() == 9
                    )
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereSecondAddressMore42AndUpto52()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter(
                            r -> r.getAddress().getCoord()[1] > 42 &&
                                 r.getAddress().getCoord()[1] < 52
                    )
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        map.put("borough",r.getBorough());
                        map.put("cuisine",r.getCuisine());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter(r -> r.getGrades().length > 1)
                    .filter(
                            r -> r.getAddress().getCoord()[1] > 42 &&
                                    r.getAddress().getCoord()[1] < 52
                    )
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsNameSortedByName()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                                    .stream()
                                    .sorted(Comparator.comparing(Restaurant::getName))
                                    .map((r) -> {
                                        Map<String, String> map = new HashMap<>();
                                        map.put("_id",r.getId());
                                        map.put("name",r.getName());
                                        return map;
                                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Restaurant::getName))
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsNameSortedByNameDescending()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Restaurant::getName).reversed())
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsNameSortedByCuisineAscAndBoroughDesc()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .sorted(
                            Comparator.comparing(Restaurant::getCuisine).thenComparing(
                            Comparator.comparing(Restaurant::getBorough).reversed())
                    )
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsStreetAddressExists()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .sorted(
                            Comparator.comparing(Restaurant::getCuisine).thenComparing(
                                    Comparator.comparing(Restaurant::getBorough).reversed())
                    )
                    .map((r) -> {
                        String exists = r.getAddress().getStreet().isEmpty() ? "false" : "true";
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("contains_street",(exists));
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereCoordFieldIsDouble()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> Arrays.stream(r.getAddress().getCoord())
                                        .anyMatch( i -> BigDecimal.valueOf(i).scale() > 0))
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("address",r.getAddress().toString());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> Arrays.stream(r.getAddress().getCoord())
                            .anyMatch( i -> BigDecimal.valueOf(i).scale() > 0))
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereScoreGradeReturns0AfterDividedBy7()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> Arrays.stream(r.getGrades())
                            .anyMatch( g -> g.getScore() % 7 == 0))
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("grades",r.getGrades().toString());
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> Arrays.stream(r.getGrades())
                            .anyMatch( g -> g.getScore() % 7 == 0))
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereNameContainsWithmon()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> r.getName().contains("mon"))
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        map.put("borough",r.getBorough());
                        map.put("longitude",r.getAddress().getCoord()[0]+"");
                        map.put("latitude",r.getAddress().getCoord()[1]+"");
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> r.getName().contains("mon"))
                    .count();
            log.info("Total : "+count);
        } catch ( Exception e)
        {   e.printStackTrace();
            lstResultado = new ArrayList<>();
        }

        return lstResultado;
    }

    @Override
    public List<Map<String, String>> getRestaurantsWhereNameStartsWithMad()
    {   List<Map<String,String>> lstResultado = new ArrayList<>();
        try
        {
            lstResultado = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> r.getName().startsWith("Mad"))
                    .map((r) -> {
                        Map<String, String> map = new HashMap<>();
                        map.put("_id",r.getId());
                        map.put("name",r.getName());
                        map.put("borough",r.getBorough());
                        map.put("longitude",r.getAddress().getCoord()[0]+"");
                        map.put("latitude",r.getAddress().getCoord()[1]+"");
                        return map;
                    }).collect(Collectors.toList());

            Long count = restaurantRepository.findAll()
                    .stream()
                    .filter( r -> r.getName().startsWith("Mad"))
                    .count();
            log.info("Total : "+count);
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
