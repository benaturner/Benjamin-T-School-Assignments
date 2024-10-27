/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblemodel;

/**
 *
 * @author bent3
 */
public class Verse {
    private final String text;
    private final String id;
    
    public Verse(String id, String text){
        this.id = id;
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
    public String getId(){
        return id;
    }
    
    public String toString(){
        return getId() + " " + getText();
    }
}
