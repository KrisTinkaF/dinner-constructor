package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishesByCategories;

    DinnerConstructor() {
        dishesByCategories = new HashMap<>();
    }

    public void saveDishes(String dishType, String dishName) {
        ArrayList<String> dishes;
        if (dishesByCategories.containsKey(dishType)) {
            dishes = dishesByCategories.get(dishType);
            dishes.add(dishName);
        } else {
            dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByCategories.put(dishType, dishes);
        }
        System.out.println("Список сохраненных блюд:");
        for (String category : dishesByCategories.keySet()) {
            System.out.println("Категория: "+ category);
            for (String dish : dishesByCategories.get(category)) {
                System.out.println(dish);
            }
        }

    }

    boolean checkType(String dishType) {
        return dishesByCategories.containsKey(dishType);
    }

    public void generateCombos(int numberOfCombos, ArrayList<String> dishTypes) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String dishtype : dishTypes) {
                ArrayList<String> dishesInCategory = dishesByCategories.get(dishtype);
                int randomDishIndex = new Random().nextInt(dishesInCategory.size());
                combo.add(dishesInCategory.get(randomDishIndex));
            }
            System.out.println("Комбо "+i);
            System.out.println(combo);
        }
    }
}
