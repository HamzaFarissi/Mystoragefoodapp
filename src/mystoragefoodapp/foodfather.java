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
    
       
    // Attributes of the father
    protected String foodName;
    protected double foodWeight;
    protected LocalDate foodDate;
    protected LocalDateTime foodTime;

    // Constructor of the father
    public foodfather(String name, double weight, LocalDate bestBeforeDate) {
        this.foodName = name;
        this.foodWeight = weight;
        this.foodDate = bestBeforeDate;
        this.foodTime = LocalDateTime.now();
        
    }
    
}

