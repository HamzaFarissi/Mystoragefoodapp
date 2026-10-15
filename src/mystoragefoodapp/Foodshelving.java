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
    
    int max_capacity = 10; 
    public List<foodfather> storage= new ArrayList<>(); 
    public int count;

    public void AddFood(int option, double weight, LocalDate dateFood){
        //Thay are more space for food
        storage.add(MyFood(option, weight, dateFood));
    }
    
    public void RemoveFood(String lf){
        if (storage.isEmpty()) return;
        
        if ("LIFO".equals(lf)) {
            storage.remove(storage.size() - 1);
        } else if ("FIFO".equals(lf)) {
            storage.remove(0);
            System.out.println("\n   fdgfdfdfdgfdgf");
        }
    }
    
    public foodfather PickAnyFood(String lf) {
        if (storage.isEmpty()) {
            return null;
        }
        
        if ("LIFO".equals(lf)){
            return storage.get(storage.size()-1);
        } else {
            return storage.get(0);
        }
    }
    
    public boolean FullStore(){
        return storage.size() == max_capacity;
    }
    
    foodfather MyFood(int myFoodOption, double weight, LocalDate dateFood){
        switch (myFoodOption){
            case 1 -> {
                return new Burger(weight, dateFood);
            }
            case 2 -> {
                return new Pizza(weight, dateFood);
            }
            case 3 -> {
                return new Fries(weight, dateFood);
            }
            case 4 -> {
                return new Sandwich(weight, dateFood);
            }
            case 5 -> {
                return new Hotdog(weight, dateFood);
            }
        }
        return null;
    }
    
    
    public static class Burger extends foodfather {

        public Burger(double weight, LocalDate bestBeforeDate) {
            super("Burger", weight, bestBeforeDate);
        }
    }

    public static class Pizza extends foodfather {

        public Pizza(double weight, LocalDate bestBeforeDate) {
            super("Pizza", weight, bestBeforeDate);
        }
    }

    public static class Fries extends foodfather {

        public Fries(double weight, LocalDate bestBeforeDate) {
            super("Fries", weight, bestBeforeDate);
        }
    }

    public static class Sandwich extends foodfather {

        public Sandwich(double weight, LocalDate bestBeforeDate) {
            super("Sandwich", weight, bestBeforeDate);
        }
    }

    public static class Hotdog extends foodfather {

        public Hotdog(double weight, LocalDate bestBeforeDate) {
            super("Hotdog", weight, bestBeforeDate);
        }
    }
    
    
    
}

