package com.ljp.designpatterns.builder.one;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
