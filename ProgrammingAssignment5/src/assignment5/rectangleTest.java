/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment5;

/**
 *
 * @author bent3
 */

import java.util.Scanner;

public class rectangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        int ch = 0;
        Rectangle r = new Rectangle();
        Circle c = new Circle();
        
        while(ch != 5){
            printMenu();
            ch = userChoice();
            System.out.println();
            
            switch(ch){
                case 1:
                    System.out.print("Input rectangle length: ");
                    double input = i.nextDouble();
                    try{
                        r.setLength(input);
                    }
                    catch(Exception e){
                        System.out.println("Invalid value.");
                    }
                    break;
                case 2:
                    System.out.print("Input rectangle width: ");
                    input = i.nextDouble();
                    try{
                        r.setWidth(input);
                    }
                    catch(Exception e){
                        System.out.println("Invalid value.");
                    }
                    break;
                case 3:
                    System.out.print("Input circle radius: ");
                    input = i.nextDouble();
                    try{
                        c.setRadius(input);
                    }
                    catch(Exception e){
                        System.out.println("Invalid value.");
                    }
                    break;
                case 4:
                    System.out.println(r.toString());
                    System.out.println(c.toString());
                    break;
                case 5:
                    System.out.println("Program exited");
                    break;
            }
            System.out.println();
        }
    }
    
    public static void printMenu(){
        System.out.println("1. Set Rectangle Length");
        System.out.println("2. Set Rectangle Width");
        System.out.println("3. Set Circle Radius");
        System.out.println("4. Return Results");
        System.out.println("5. Exit");
    }
    
    public static int userChoice(){
        Scanner i = new Scanner(System.in);
        System.out.print("Choice: ");
        int choice = i.nextInt();
        
        while(choice < 1 || choice > 6)
        {
            System.out.println("Please enter a valid choice.");
            System.out.print("Choice: ");
            choice = i.nextInt();
        }
        return choice;
    }
    
}
