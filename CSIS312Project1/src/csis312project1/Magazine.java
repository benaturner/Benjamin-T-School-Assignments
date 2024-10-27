/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csis312project1;

/**
 *
 * @author bent3
 */
public class Magazine extends Media {

    double issueCost;
    int issuesPerYear;
    
    public Magazine(String title, String publicationDate, double issueCost, int issuesPerYear) {
        
        super(title, publicationDate);
        
        this.issueCost = issueCost;
        this.issuesPerYear = issuesPerYear;
    }

    @Override
    public String print() {
        return "Title: " + title + ", Date: " + publicationDate + ", Issues: " + issuesPerYear;
    }

    @Override
    public double getCost() {
        return issueCost;
    }
}
