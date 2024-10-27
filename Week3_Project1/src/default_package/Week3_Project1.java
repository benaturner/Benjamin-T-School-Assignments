/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package default_package;

/**
 *
 * @author bent3
 */
import java.util.Scanner;

public class Week3_Project1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Benjamin Turner Assignment 1");
        System.out.print("Enter 1st integer: ");
        int i1 = input.nextInt();
        System.out.print("Enter 2nd integer: ");
        int i2 = input.nextInt();
        System.out.print("Enter 3rd integer: ");
        int i3 = input.nextInt();
        System.out.print("Enter 4th integer: ");
        int i4 = input.nextInt();
        System.out.println(i1 + " " + i2 + " " + i3 + " " + i4);
        System.out.println(i1+i2+i3+i4);
        System.out.println(i1*i2-i3*i4);
        System.out.println(i1*(i2+i3)*i4);
        System.out.println((i1+i2+i3+i4)%i1);
        if (i1 > i2)
            System.out.printf("%d\n", i2);
        else
            System.out.printf("%d\n", i1);
        if (i1+i2 > i3*i4)
            System.out.printf("%d\n", i1+i2);
        else
            System.out.printf("%d\n", i3*i4);
        if (i1%i2 == 0)
            System.out.println(i1 + " is a multiple of " + i2);
        else
            System.out.println(i1 + " is not a multiple of " + i2);
        if (i1%i3 == 0)
            System.out.println(i1 + " is a multiple of " + i3);
        else
            System.out.println(i1 + " is not a multiple of " + i3);
        if (i1%i4 == 0)
            System.out.println(i1 + " is a multiple of " + i4);
        else
            System.out.println(i1 + " is not a multiple of " + i4);
         
    }
}