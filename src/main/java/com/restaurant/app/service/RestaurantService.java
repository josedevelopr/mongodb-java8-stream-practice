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
    List<Restaurant> getRestaurantsBoroughBronx();
    List<Restaurant> getRestaurantsBoroughBronxSkippingFive();
    List<Restaurant> getRestaurantsGradeScoreMoreNinety();
    List<Restaurant> getRestaurantsGradeScoreMoreEightyAndLessOneHundred();
    List<Restaurant> getRestaurantsLocateInLatitudeLessThan();
    List<Restaurant> getRestaurantsCuisineNotAmericanScoreMoreSeventyAndLatitudeLessThan();
    List<Restaurant> getRestaurantsCuisineNotAmericanGradePointAAndBoroughBrooklyn();
    List<Map<String, String>> getIdNameWhereNameStartsWithWil();
    List<Map<String, String>> getIdNameBoroughCuisineWhereNameFinishesCes();
    List<Map<String, String>> getIdNameBoroughCuisineWhereNameContainsReg();
    List<Restaurant> getRestaurantsWhereBorouhgBronxCuisineAmericanOrChinese();
    List<Map<String, String>> getRestaurantsWhereBoroughStateIslandOrQueensOrBrooklyn();
    List<Map<String, String>> getRestaurantsWhereBoroughIsNotStateIslandOrQueensOrBrooklyn();
    List<Map<String, String>> getRestaurantsWhereGradeScoreNotMoreThan10();
    List<Map<String, String>> getRestaurantsWhereCuisineNotAmericanOrChinese();
    List<Map<String, String>> getRestaurantsWhereGradeAandScore11AndISODate20140811();
    List<Map<String, String>> getRestaurantsWhereSecondGradeAandScore9AndISODate20140811();
    List<Map<String, String>> getRestaurantsWhereSecondAddressMore42AndUpto52();
    List<Map<String, String>> getRestaurantsNameSortedByName();
    List<Map<String, String>> getRestaurantsNameSortedByNameDescending();
    List<Map<String, String>> getRestaurantsNameSortedByCuisineAscAndBoroughDesc();
    List<Map<String, String>> getRestaurantsStreetAddressExists();
    List<Map<String, String>> getRestaurantsWhereCoordFieldIsDouble();
    List<Map<String, String>> getRestaurantsWhereScoreGradeReturns0AfterDividedBy7();
    List<Map<String, String>> getRestaurantsWhereNameContainsWithmon();
}
