/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblemodel;



/**
 *
 * @author wschofield
 */
public class BibleTest
{
    public static void main (String args[])
    {        
        // Create parts
        Bible bible = new Bible("NIV");
        Book b = new Book(bible.getId() + " Genesis");
        Chapter c = new Chapter(b.getId() + " 1");
        Verse v = new Verse(c.getId() + ":1 ","In the beginning God created the heavens and the earth.");
        
        // Add to collections
        c.addVerse(v);
        b.addChapter(c);
        bible.addBook(b);
        System.out.println(bible.toString());
    }
}