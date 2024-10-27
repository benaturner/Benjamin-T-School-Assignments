/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment5;

/**
 *
 * @author bent3
 */
public class Rectangle {
    private double width;
    private double length;
    
    public Rectangle(){
        width = 1;
        length = 1;
    }
    
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    
    public double calcArea(){
        return width * length;
    }
    
    public double calcPerim(){
        return (2 * width) + (2 * length);
    }
    
    public String toString(){
        String output = "The perimeter of the rectangle is: " + calcPerim() + "\n";
        output += "The area of the rectangle is: " + calcArea();
        return output;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0 || width > 20)
            throw new IllegalArgumentException();
        else
            this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length <= 0 || length > 20)
            throw new IllegalArgumentException();
        else
            this.length = length;
    }
    
    
}