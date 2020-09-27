package com.restaurant.app.service;

import com.restaurant.app.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService
{
    List<Restaurant> findAll();
    List<Map<String, String>> getNameBoroughAndCuisine();
    List<Map<String, String>> getNameBoroughCuisineAndRestaurantId();
    List<Map<String, String>> getNameBoroughRestaurantIdAndZipCode();
    List<Restaurant> geRestaurantsBoroughBronx();
    List<Restaurant> geRestaurantsBoroughBronxSkippingFive();
    List<Restaurant> geRestaurantsGradeScoreMoreNinety();
    List<Restaurant> geRestaurantsGradeScoreMoreEightyAndLessOneHundred();
    List<Restaurant> geRestaurantsLocateInLatitudeLessThan();
    List<Restaurant> geRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan();
    List<Restaurant> geRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn();
    List<Map<String, String>> getIdNameWhereNameStartsWithWil();
    List<Map<String, String>> getIdNameBoroughCuisineWhereNameFinishesCes();
    List<Map<String, String>> getIdNameBoroughCuisineWhereNameContainsReg();
    List<Restaurant> geRestaurantsWhereBorouhgBronxCuisineAmericanOrChinese();
    List<Map<String, String>> geRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn();
    List<Map<String, String>> geRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn();
    List<Map<String, String>> geRestaurantsWhereGradeScoreNotMoreThan10();
    List<Map<String, String>> geRestaurantsWhereCuisineNotAmericanOrChinese();
    List<Map<String, String>> geRestaurantsWhereGradeAandScore11AndISODate20140811();

}
