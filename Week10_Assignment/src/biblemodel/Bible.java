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
public class Bible
{
    private final String id;
    private final ArrayList<Book> books;
    
    public Bible(String id)
    {
        this.id = id;
        books = new ArrayList<>();
    }
    
    public void addBook(Book b)
    {
        getBooks().add(b);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(System.lineSeparator());
        for (Book b : getBooks())
        {
            sb.append(b.toString());
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
    public ArrayList<Book> getBooks()
    {
        return books;
    }
}
