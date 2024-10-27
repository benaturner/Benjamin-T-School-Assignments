/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author bent3
 */

public class Circle {
    private double radius;
    
    public Circle(){
        radius = 1;
    }
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public double calcArea(){
        return Math.PI * (radius * radius);
    }
    
    public double calcPerim(){
        return Math.PI * 2 * radius;
    }
    
    public String toString(){
        String string = "The perimeter of the circle is: " + calcPerim() + "\n";
        string += "The area of the circle is: " + calcArea();    
        return string;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius <= 0 || radius > 20)
            throw new IllegalArgumentException();
        else
            this.radius = radius;
        }
    }

