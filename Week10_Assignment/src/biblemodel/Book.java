/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblemodel;

import java.util.ArrayList;

/**
 *
 * @author wschofield
 */
public class Book
{
    private final String id;
    private final ArrayList<Chapter> chapters;
    
    public Book(String id)
    {
        this.id = id;
        chapters = new ArrayList<>();
    }
    
    public void addChapter(Chapter c)
    {
        getChapters().add(c);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(System.lineSeparator());
        for (Chapter c : getChapters())
        {
            sb.append(c.toString());
        }
        return sb.toString();
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return the verses
     */
    public ArrayList<Chapter> getChapters()
    {
        return chapters;
    }
}
