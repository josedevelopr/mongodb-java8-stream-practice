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

    @GetMapping("/ejercicio03")
    public @ResponseBody
    ResponseEntity getNameBoroughCuisineAndRestaurantId()
    {   List<Map<String,String>>lstResultado = restaurantService.getNameBoroughCuisineAndRestaurantId();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio04")
    public @ResponseBody
    ResponseEntity getNameBoroughRestaurantIdAndZipCode()
    {   List<Map<String,String>>lstResultado = restaurantService.getNameBoroughRestaurantIdAndZipCode();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio05")
    public @ResponseBody
    ResponseEntity geRestaurantsBoroughBronx()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsBoroughBronx();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio07")
    public @ResponseBody
    ResponseEntity geRestaurantsBoroughBronxSkippingFive()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsBoroughBronxSkippingFive();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio08")
    public @ResponseBody
    ResponseEntity geRestaurantsGradeScoreMoreNinety()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsGradeScoreMoreNinety();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio09")
    public @ResponseBody
    ResponseEntity geRestaurantsGradeScoreMoreEightyAndLessOneHundred()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsGradeScoreMoreEightyAndLessOneHundred();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio10")
    public @ResponseBody
    ResponseEntity geRestaurantsLocateInLatitudeLessThan()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsLocateInLatitudeLessThan();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio11")
    public @ResponseBody
    ResponseEntity geRestaurantsCuisineNotAmerican()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio13")
    public @ResponseBody
    ResponseEntity geRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio14")
    public @ResponseBody
    ResponseEntity getIdNameWhereBoroughStartsWithWil()
    {   List<Map<String,String>>lstResultado = restaurantService.getIdNameWhereNameStartsWithWil();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio15")
    public @ResponseBody
    ResponseEntity getIdNameBoroughCuisineWhereNameStartsWithCes()
    {   List<Map<String,String>>lstResultado = restaurantService.getIdNameBoroughCuisineWhereNameFinishesCes();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio16")
    public @ResponseBody
    ResponseEntity getIdNameBoroughCuisineWhereNameContainsReg()
    {   List<Map<String,String>>lstResultado = restaurantService.getIdNameBoroughCuisineWhereNameContainsReg();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio17")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereCuisineAmericanOrChinese()
    {   List<Restaurant> lstResultado = restaurantService.geRestaurantsWhereBorouhgBronxCuisineAmericanOrChinese();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio18")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>>lstResultado = restaurantService.geRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio19")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>>lstResultado = restaurantService.geRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio20")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereGradeScoreNotMoreThan10()
    {   List<Map<String,String>>lstResultado = restaurantService.geRestaurantsWhereGradeScoreNotMoreThan10();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio21")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereCuisineNotAmericanOrChinese()
    {   List<Map<String,String>>lstResultado = restaurantService.geRestaurantsWhereCuisineNotAmericanOrChinese();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio22")
    public @ResponseBody
    ResponseEntity geRestaurantsWhereGradeAandScore11AndISODate20140811()
    {   List<Map<String,String>>lstResultado = restaurantService.geRestaurantsWhereGradeAandScore11AndISODate20140811();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }
}
