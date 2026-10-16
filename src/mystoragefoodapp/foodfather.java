/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mystoragefoodapp;

import java.time.LocalDate ;
import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class foodfather {
    
    // Food information

    // Food name
    protected String foodName;

    // Food weight
    protected double foodWeight;

    // Food best-before date
    protected LocalDate foodDate;

    // Food date and time
    protected LocalDateTime foodTime;

    // Create a new food item
    public foodfather(String name, double weight, LocalDate bestBeforeDate) {

        // Set the food name
        this.foodName = name;

        // Set the food weight
        this.foodWeight = weight;

        // Set the best-before date
        this.foodDate = bestBeforeDate;

        // Get the current date and time
        this.foodTime = LocalDateTime.now();
        
    }
    
}
