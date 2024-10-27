/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csis312project1;

/**
 *
 * @author bent3
 */
public abstract class Media implements MediaUtility {
    public String title;
    public String publicationDate;
    
    public Media (String title, String publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }
    
    public String getTitle() {
        return title;
    }
    
    int compareTo() {
        return 0;
    }
    
    String getPublicationDate() {
        return publicationDate;
    }
    
    public double getCost() {
        return cost;
    }
    
}
