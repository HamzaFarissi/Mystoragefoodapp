/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mystoragefoodapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Foodshelving {

    // Set the max number of food items
    int max_capacity = 10;

    // Make a list to store food
    public List<foodfather> storage = new ArrayList<>();

    // Count the food items
    public int count;

    // Add food to the storage
    public void AddFood(int option, double weight, LocalDate dateFood) {

        // Add the new food to the list
        storage.add(MyFood(option, weight, dateFood));
    }

    // Remove food from the storage
    public void RemoveFood(String lf) {

        // Check if the list is empty
        if (storage.isEmpty()) return;

        // Check if the rule is LIFO
        if ("LIFO".equals(lf)) {

            // Remove the last food
            storage.remove(storage.size() - 1);

        // Check if the rule is FIFO
        } else if ("FIFO".equals(lf)) {

            // Remove the first food
            storage.remove(0);
            System.out.println("\n   fdgfdfdfdgfdgf");
        }
    }

    // Pick one food from the storage
    public foodfather PickAnyFood(String lf) {

        // Check if the list is empty
        if (storage.isEmpty()) {
            return null;
        }

        // Check if the rule is LIFO
        if ("LIFO".equals(lf)) {

            // Get the last food
            return storage.get(storage.size() - 1);

        // Get the first food
        } else {
            return storage.get(0);
        }
    }

    // Check if the storage is full
    public boolean FullStore() {
        return storage.size() == max_capacity;
    }

    // Make food from the selected option
    foodfather MyFood(int myFoodOption, double weight, LocalDate dateFood) {

        // Check the food option
        switch (myFoodOption) {

            // Create a Burger
            case 1 -> {
                return new Burger(weight, dateFood);
            }

            // Create a Pizza
            case 2 -> {
                return new Pizza(weight, dateFood);
            }

            // Create Fries
            case 3 -> {
                return new Fries(weight, dateFood);
            }

            // Create a Sandwich
            case 4 -> {
                return new Sandwich(weight, dateFood);
            }

            // Create a Hotdog
            case 5 -> {
                return new Hotdog(weight, dateFood);
            }
        }

        // Return nothing if the option is wrong
        return null;
    }

    // Burger class
    public static class Burger extends foodfather {

        // Create a Burger with its weight and date
        public Burger(double weight, LocalDate bestBeforeDate) {
            super("Burger", weight, bestBeforeDate);
        }
    }

    // Pizza class
    public static class Pizza extends foodfather {

        // Create a Pizza with its weight and date
        public Pizza(double weight, LocalDate bestBeforeDate) {
            super("Pizza", weight, bestBeforeDate);
        }
    }

    // Fries class
    public static class Fries extends foodfather {

        // Create Fries with their weight and date
        public Fries(double weight, LocalDate bestBeforeDate) {
            super("Fries", weight, bestBeforeDate);
        }
    }

    // Sandwich class
    public static class Sandwich extends foodfather {

        // Create a Sandwich with its weight and date
        public Sandwich(double weight, LocalDate bestBeforeDate) {
            super("Sandwich", weight, bestBeforeDate);
        }
    }

    // Hotdog class
    public static class Hotdog extends foodfather {

        // Create a Hotdog with its weight and date
        public Hotdog(double weight, LocalDate bestBeforeDate) {
            super("Hotdog", weight, bestBeforeDate);
        }
    }
    
    // Display all food items currently in storage
    public void DisplayAllElements() {
    
    // Check if the list is empty
    if (storage.isEmpty()) {
        System.out.println("Storage is empty.");
        return;
    }

    // Print table title
    System.out.println("--- ALL STORED FOOD ---");

    // Loop through each item in the storage list
    for (int i = 0; i < storage.size(); i++) {
        
        // Get the current food item
        foodfather item = storage.get(i);

        // Print item details one by one
        System.out.println("Number: " + (i + 1));
        System.out.println("Name: " + item.foodName);
        System.out.println("Weight: " + item.foodWeight);
        System.out.println("Date: " + item.foodDate);
        System.out.println("------------------------");
    }
}

}
