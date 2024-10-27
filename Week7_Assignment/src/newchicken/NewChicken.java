/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newchicken;

/**
 *
 * @author bent3
 */
import java.util.Scanner;

public class NewChicken {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static int numChickens;
    static double eggsPerHen;
    static double costPerPound;
    static double eggCartonCost;
    static double feedPerHenPerDay;
    static double eggsPerMonth;
    static double totalFeedCost;
    static double totalCartonCost;
    static double totalCost;
    static double numDozenEggs;
    static double operatingCost;
    
    public static void main(String[] args){
        int selection;
        Scanner select = new Scanner(System.in);
        int loop = 1;
        int loop2;
        setNumChickens();
        setEggsPerHen();
        setCostPerPound();
        setEggCartonCost();
        setFeedPerHenPerDay();
        while(loop == 1) {
            cls();
            System.out.printf("Number of Chickens: %d\n\nEggs laid per hen per day: %.2f\n\nFeed Cost Per Pound: $%.2f\n\nFeed(lb) Per Hen Per Day: %.2f\n\nCost Per Carton: $%.2f\n\n\n", numChickens, eggsPerHen, costPerPound, feedPerHenPerDay, eggCartonCost);
            loop2 = 1;
            while(loop2 == 1){
                System.out.print("1. Update Flock\n\n2. Update Eggs Per Hen\n\n3. Update Feed Cost Per Pound\n\n4. Update Feed Per Hen Per Day (lb)\n\n5. Update Egg Carton Cost\n\n6. Show Totals\n\n0. Exit\n\n\n");
                System.out.print("Enter Selection: ");
                selection = select.nextInt();
                switch(selection)
                {
                    case 1:
                        setNumChickens();
                        loop2 = 0;
                        break;
                    case 2:
                        setEggsPerHen();
                        loop2 = 0;
                        break;
                    case 3:
                        setCostPerPound();
                        loop2 = 0;
                        break;
                    case 4:
                        setFeedPerHenPerDay();
                        loop2 = 0;
                        break;
                    case 5:
                        setEggCartonCost();
                        loop2 = 0;
                        break;
                    case 6:
                        eggsPerMonth = numChickens*eggsPerHen*30;
                        totalFeedCost = numChickens*feedPerHenPerDay*30*costPerPound;
                        totalCartonCost = Math.floor((eggsPerMonth/12))*eggCartonCost;
                        totalCost = totalFeedCost + totalCartonCost;
                        numDozenEggs = (eggsPerMonth - eggsPerMonth%20)/12;
                        operatingCost = totalCost / numDozenEggs;
                        System.out.printf("Total Eggs: %.2f\n", eggsPerMonth);
                        System.out.printf("Total Feed Cost: $%.2f\n",totalFeedCost);
                        System.out.printf("Total Carton Cost: $%.2f\n", totalCartonCost);
                        System.out.printf("It costs $%.2f to produce %.0f dozen eggs\n\n", totalCost, numDozenEggs);
                        System.out.printf("Operating cost per dozen: $%.2f\n\n", operatingCost);
                        System.exit(0);
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Input. Try Again.");
                        break;
                }
            }
        }
    }
    
    static void setNumChickens() {
        int loopCheck = 0;
        while(loopCheck == 0){
            System.out.print("Number of Chickens: ");
            numChickens = input.nextInt();
            if (numChickens > 0)
                loopCheck = 1;
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    
    static void setEggsPerHen() {
        int loopCheck = 0;
        while(loopCheck == 0){
            System.out.print("Eggs Per Hen: ");
            eggsPerHen = input.nextDouble();
            if (eggsPerHen >= 0)
                loopCheck = 1;
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    
    static void setCostPerPound() {
        int loopCheck = 0;
        while(loopCheck == 0){
            System.out.print("Feed Cost Per Pound: ");
            costPerPound = input.nextDouble();
            if (costPerPound >= 0)
                loopCheck = 1;
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    
    static void setEggCartonCost() { 
        int loopCheck = 0;
        while(loopCheck == 0){
            System.out.print("Egg Carton Cost: ");
            eggCartonCost = input.nextDouble();
            if (eggCartonCost >= 0)
                loopCheck = 1;
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    
    static void setFeedPerHenPerDay() {
        int loopCheck = 0;
        while(loopCheck == 0){
            System.out.print("Feed Per Hen Per Day (lb): ");
            feedPerHenPerDay = input.nextDouble();
            if (feedPerHenPerDay >= 0)
                loopCheck = 1;
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    
    public static void cls() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
        /*
        This code is for some reason:
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        I tried multiple different methods to clear the screen but none of them are working. This is the next best solution without extensive research.
        */
    }
}
