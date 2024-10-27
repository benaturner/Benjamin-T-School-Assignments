/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chickenegg;

/**
 *
 * @author bent3
 */
import java.util.Scanner;
public class ChickenEgg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Chickens: ");
        int numChickens = input.nextInt();
        if (numChickens <= 0)
            System.exit(0);
        System.out.print("Eggs Per Hen: ");
        double eggsPerHen = input.nextDouble();
        System.out.print("Feed Cost Per Pound: ");
        double costPerPound = input.nextDouble();
        System.out.print("Egg Carton Cost: ");
        double eggCartonCost = input.nextDouble();
        System.out.print("Feed Per Hen Per Day (lb): ");
        double feedPerHenPerDay = input.nextDouble();
        double eggsPerMonth = numChickens*eggsPerHen*30;
        double totalFeedCost = numChickens*feedPerHenPerDay*30*costPerPound;
        double totalCartonCost = Math.floor((eggsPerMonth/12))*eggCartonCost;
        double totalCost = totalFeedCost + totalCartonCost;
        double numDozenEggs = (eggsPerMonth - eggsPerMonth%20)/12;
        double operatingCost = totalCost / numDozenEggs;
        System.out.println("\nResults");
        System.out.printf("Number of Chickens: %d\nEggs laid per hen per day: %.2f\nFeedCostPerPound: $%.2f\nFeed(lb) Per Hen Per Day: %.2f\nCost Per Carton: $%.2f\n\n", numChickens, eggsPerHen, costPerPound, feedPerHenPerDay, eggCartonCost);
        System.out.printf("Total Eggs: %.2f\n", eggsPerMonth);
        System.out.printf("Total Feed Cost: $%.2f\n",totalFeedCost);
        System.out.printf("Total Carton Cost: $%.2f\n", totalCartonCost);
        System.out.printf("It costs $%.2f to produce %.0f dozen eggs\n\n", totalCost, numDozenEggs);
        System.out.printf("Operating cost per dozen: $%.2f\n\n", operatingCost);
        System.out.println("Assignment Part B - Vary Feed Costs +/- 25%\n");
        System.out.printf("%15s%25s", "Total Cost", "Per Pound Feed Cost");
        double tempCostPerPound = costPerPound * .75;
        double tempTotalCost = numChickens*feedPerHenPerDay*30*tempCostPerPound + totalCartonCost;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%n          %.2f                %.2f", tempTotalCost, tempCostPerPound);
            tempCostPerPound = tempCostPerPound + costPerPound * .05;
            tempTotalCost = numChickens*feedPerHenPerDay*30*tempCostPerPound + totalCartonCost;
        }
        System.out.println();
    }
    
}
