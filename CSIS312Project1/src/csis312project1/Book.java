/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csis312project1;

/**
 *
 * @author bent3
 */

// Book class declaration as part of the Library program
public class Book extends Media {

    // Initialize private instance variables
    private String author;
    private double cost;

    // Declare a constructor for Book class
    public Book(String title, String publicationDate, String author, double cost) {
        super(title, publicationDate);
        this.author = author;
        this.cost = cost;
    }

    // Convert Book to specified String format
    public String print() {
        return String.format("b, %s , %s, %s, %s", title, publicationDate, author, cost);
    }

    // Access cost value
    public double getCost() {
        return cost;
    }

    // Access author data
    public String getAuthor() {
        return author;
    }
}

