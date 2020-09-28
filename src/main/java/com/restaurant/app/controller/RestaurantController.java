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
    ResponseEntity getRestaurantsBoroughBronx()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsBoroughBronx();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio07")
    public @ResponseBody
    ResponseEntity getRestaurantsBoroughBronxSkippingFive()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsBoroughBronxSkippingFive();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio08")
    public @ResponseBody
    ResponseEntity getRestaurantsGradeScoreMoreNinety()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsGradeScoreMoreNinety();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio09")
    public @ResponseBody
    ResponseEntity getRestaurantsGradeScoreMoreEightyAndLessOneHundred()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsGradeScoreMoreEightyAndLessOneHundred();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio10")
    public @ResponseBody
    ResponseEntity getRestaurantsLocateInLatitudeLessThan()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsLocateInLatitudeLessThan();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio11")
    public @ResponseBody
    ResponseEntity getRestaurantsCuisineNotAmerican()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio13")
    public @ResponseBody
    ResponseEntity getRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn();
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
    ResponseEntity getRestaurantsWhereCuisineAmericanOrChinese()
    {   List<Restaurant> lstResultado = restaurantService.getRestaurantsWhereBorouhgBronxCuisineAmericanOrChinese();
        return  new ResponseEntity<List<Restaurant>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio18")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio19")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio20")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereGradeScoreNotMoreThan10()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereGradeScoreNotMoreThan10();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio21")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereCuisineNotAmericanOrChinese()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereCuisineNotAmericanOrChinese();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio22")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereGradeAandScore11AndISODate20140811()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereGradeAandScore11AndISODate20140811();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio23")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereSecondGradeAandScore9AndISODate20140811()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereSecondGradeAandScore9AndISODate20140811();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio24")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereSecondAddressMore42AndUpto52()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereSecondAddressMore42AndUpto52();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio25")
    public @ResponseBody
    ResponseEntity getRestaurantsNameSortedByName()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsNameSortedByName();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio26")
    public @ResponseBody
    ResponseEntity getRestaurantsNameSortedByNameDescending()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsNameSortedByNameDescending();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio27")
    public @ResponseBody
    ResponseEntity getRestaurantsNameSortedByCuisineAscAndBoroughDesc()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsNameSortedByCuisineAscAndBoroughDesc();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio28")
    public @ResponseBody
    ResponseEntity getRestaurantsStreetAddressExists()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsStreetAddressExists();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }

    @GetMapping("/ejercicio29")
    public @ResponseBody
    ResponseEntity getRestaurantsWhereCoordFieldIsDouble()
    {   List<Map<String,String>>lstResultado = restaurantService.getRestaurantsWhereCoordFieldIsDouble();
        return  new ResponseEntity<List<Map<String,String>>>(lstResultado, HttpStatus.OK);
    }
}
