/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mystoragefoodapp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Mystoragefoodapp {

    public static void main(String[] args) {
    // Start the program

    // Create the food storage
    Foodshelving shelving = new Foodshelving();

    // Set the order to LIFO
    String system = "LIFO";

    // Read input from the user
    Scanner scanner = new Scanner(System.in);

    // Set the first option to 0
    int option = 0;

    // Show the menu until the user closes the program
    do {

        // Show the main menu
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("|               FOOD INVENTORY                     |");
        System.out.println("+--------------------------------------------------+");

        // Show the active order
        System.out.printf("   Active order: %s%n%n", system);

        System.out.println("   [1] Store a meal           [2] Take out a meal");
        System.out.println("   [3] View next meal         [4] Switch order FIFO/LIFO");
        System.out.println("   [5] Display all elements   [6] Close application");

        // Show the next order
        System.out.println("\n   Switch order will activate: "
                + ("LIFO".equals(system) ? "FIFO" : "LIFO"));

        // Show the end of the menu
        System.out.println("+--------------------------------------------------+");

        // Ask the user to choose an option
        System.out.print("   Your choice [1-6] > ");

        // Check if the input is a whole number
        if (scanner.hasNextInt()) {

            // Read the user's choice
            option = scanner.nextInt();

        } else {

            // Remove the wrong input
            scanner.next();

            // Show an error message
            System.out.println("\n   A whole number is required. Try again.");

            // Start the loop again
            continue;
        }

        // Check the user's choice
        switch (option) {

            case 1:

                // Check if the storage is full
                if (shelving.FullStore()) {
                    System.out.println("\n   All storage spaces are occupied.");
                    System.out.println("   Remove an item before adding another.");
                    break;
                }

                // Store the food choice
                int foodType;

                // Ask the user to choose a meal
                do {
                    System.out.println("\n   +---------- CHOOSE A MEAL ----------+");
                    System.out.println("   |  [1] Burger       [2] Pizza       |");
                    System.out.println("   |  [3] Fries        [4] Sandwich    |");
                    System.out.println("   |  [5] Hotdog       [6] Go back     |");
                    System.out.println("   +----------------------------------+");
                    System.out.print("\n   Meal selection [1-6] > ");

                    // Check if the input is a whole number
                    if (scanner.hasNextInt()) {
                        foodType = scanner.nextInt();

                        // Check if the choice is correct
                        if (foodType < 1 || foodType > 6) {
                            System.out.println(
                                    "\n   Choose one of the six listed options.");
                        }

                    } else {

                        // Remove the wrong input
                        scanner.next();

                        // Set the choice to 0
                        foodType = 0;

                        // Ask for a number
                        System.out.println(
                                "\n   Enter the number beside your chosen meal.");
                    }

                } while (foodType < 1 || foodType > 6);

                // Go back to the main menu
                if (foodType == 6) {
                    System.out.println("\n   Adding a meal was cancelled.");
                    break;
                }

                // Store the food weight
                double weight;

                // Show the weight section
                System.out.println("\n   ---- MEAL WEIGHT ----");

                // Ask for a correct weight
                do {
                    System.out.print("   Weight in grams > ");

                    // Check if the input is a number
                    if (scanner.hasNextDouble()) {
                        weight = scanner.nextDouble();

                        // Check if the weight is correct
                        if (!Double.isFinite(weight) || weight <= 0) {
                            System.out.println(
                                    "\n   Provide a positive, finite weight.");
                        }

                    } else {

                        // Remove the wrong input
                        scanner.next();

                        // Set the weight to 0
                        weight = 0;

                        // Ask for a number
                        System.out.println(
                                "\n   The weight must be entered as a number.");
                    }

                } while (!Double.isFinite(weight) || weight <= 0);

                // Store the best-before date
                LocalDate bestBeforeDate = null;

                // Check if the date is correct
                boolean validDate = false;

                // Show the date section
                System.out.println("\n   ---- BEST-BEFORE DATE ----");

                // Set the first date format
                DateTimeFormatter dayFirst = DateTimeFormatter
                        .ofPattern("dd-MM-uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

                // Set the second date format
                DateTimeFormatter monthFirst = DateTimeFormatter
                        .ofPattern("MM/dd/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

                // Show the accepted date formats
                System.out.println("\n   ---- BEST-BEFORE DATE ----");
                System.out.println("   Accepted formats: DD-MM-YYYY or MM/DD/YYYY");
                System.out.println("   Examples: 14-10-2026 or 10/14/2026");

                // Ask for a correct date
                do {
                    System.out.print("\n   Enter the date > ");

                    // Read the date
                    String dateInput = scanner.next();

                    try {
                        // Choose the date format
                        DateTimeFormatter formatter =
                                dateInput.contains("/") ? monthFirst : dayFirst;

                        // Change the text to a date
                        bestBeforeDate = LocalDate.parse(dateInput, formatter);

                        // Get today's date
                        LocalDate today = LocalDate.now();

                        // Check if the date is in the past
                        if (bestBeforeDate.isBefore(today)) {
                            System.out.println("   Choose today or a later date.");

                        // Check if the date is more than 14 days away
                        } else if (bestBeforeDate.isAfter(today.plusDays(14))) {
                            System.out.println("   Choose a date within the next 14 days.");

                        } else {

                            // The date is correct
                            validDate = true;
                        }

                    } catch (DateTimeParseException e) {

                        // Show an error for a wrong date
                        System.out.println(
                                "   Enter a valid date using DD-MM-YYYY or MM/DD/YYYY.");
                    }

                } while (!validDate);

                // Add the meal to the storage
                shelving.AddFood(foodType, weight, bestBeforeDate);

                // Show a success message
                System.out.println("\n   Your meal is now stored.");

                // Show a success message
                System.out.println("\n   Your meal is now stored.");

                break;

            case 2:

                // Show the remove meal section
                System.out.println("\n   +---------- TAKE OUT A MEAL ----------+");

                // Show the removal order
                System.out.println("   Removal order: " + system);

                // Get the next meal
                foodfather selectedFood = shelving.PickAnyFood(system);

                // Check if there is food in the storage
                if (selectedFood == null) {
                    System.out.println("\n   There are no meals in storage.");
                    System.out.println("   Removal cannot continue.");
                    break;
                }

                // Show the meal information
                System.out.println("\n   Next meal for removal");
                System.out.println("   --------------------------------------");
                System.out.println("   Meal        > " + selectedFood.foodName);
                System.out.println("   Grams       > " + selectedFood.foodWeight);
                System.out.println("   Best before > " + selectedFood.foodDate);
                System.out.println("   --------------------------------------");

                // Ask the user to confirm
                System.out.println("\n   [1] Remove this meal    [2] Keep this meal");

                // Store the user's decision
                int confirm;

                // Ask for a correct decision
                do {
                    System.out.print("\n   Your decision [1-2] > ");

                    // Check if the input is a whole number
                    if (scanner.hasNextInt()) {
                        confirm = scanner.nextInt();

                        // Check if the choice is 1 or 2
                        if (confirm != 1 && confirm != 2) {
                            System.out.println(
                                    "\n   Enter 1 to remove or 2 to return.");
                        }

                    } else {

                        // Remove the wrong input
                        scanner.next();

                        // Set the choice to 0
                        confirm = 0;

                        // Ask for a whole number
                        System.out.println(
                                "\n   Your decision must be a whole number.");
                    }

                } while (confirm != 1 && confirm != 2);

                // Remove the meal if the user chooses 1
                if (confirm == 1) {
                    shelving.RemoveFood(system);
                    System.out.println("\n   The selected meal has been taken out.");

                } else {

                    // Keep the meal in the storage
                    System.out.println("\n   The meal remains in storage.");
                }

                break;

            case 3:

                // Show the next meal section
                System.out.println("\n   +---------- NEXT AVAILABLE MEAL ----------+");

                // Get the next meal
                foodfather nextFood = shelving.PickAnyFood(system);

                // Check if the storage is empty
                if (nextFood == null) {
                    System.out.println("\n   No stored meals are available to view.");
                    break;
                }

                // Show the next meal information
                System.out.println("\n   Order       > " + system);
                System.out.println("   Meal        > " + nextFood.foodName);
                System.out.println("   Grams       > " + nextFood.foodWeight);
                System.out.println("   Best before > " + nextFood.foodDate);
                System.out.println("\n   +-----------------------------------------+");

                break;

            case 4:

                // Save the old order
                String previousSystem = system;

                // Change the order from LIFO to FIFO or FIFO to LIFO
                system = "LIFO".equals(system) ? "FIFO" : "LIFO";

                // Show the new order
                System.out.println("\n   ---- STORAGE ORDER UPDATED ----");
                System.out.println("   " + previousSystem + "  -->  " + system);
                System.out.println("\n   Future removals will follow " + system + ".");

                break;

            case 5:
                 // Call the display method to show all items
                  shelving.DisplayAllElements();
                break;

                
            case 6:

                // Show the end message
                System.out.println("\n   +--------------------------------------+");
                System.out.println("   |          SESSION FINISHED            |");
                System.out.println("   |      Thanks for using the inventory. |");
                System.out.println("   +--------------------------------------+\n");

                break;

            default:

                // Show an error for a wrong choice
                System.out.println(
                        "\n   That choice is unavailable. Enter a number from 1 to 6.");

                break;
        }

    } while (option != 6);

    // Close the Scanner
    scanner.close();
    
    
    
    }
   
}