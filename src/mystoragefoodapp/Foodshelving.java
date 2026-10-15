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
    
   
    
    
}

