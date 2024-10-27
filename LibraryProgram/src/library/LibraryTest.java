/* CSIS312 Assignment 1 Test File - Supplied by instructor
 * Project Completed by - Ben Turner and Jack Skywalker
 * @author Wade
 */

package library;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryTest 
{
    /**
     * Reads in media list from text file
     * @param mediaList Media list to add items read to
     */
    private static void readMedia(List<Media> mediaList)
    {
        List<String> lines = Collections.emptyList();
        try
        { 
            lines = Files.readAllLines(Paths.get("src/library/media.txt"), StandardCharsets.UTF_8); 
        } 
        catch (IOException e) 
        { 
            System.out.println("Error reading media.txt. Terminating....");
            System.exit(1);
        } 
        
        for (String s : lines)
        {
            if (!s.startsWith("#"))
            {
                String[] items = s.split(",");
                if (items.length == 5)
                {
                    if (items[0].equals("b"))
                    {
                        String title = items[1].trim();
                        String date = items[2].trim();
                        String author = items[3].trim();
                        double cost = Double.parseDouble(items[4].trim());
                        Book b = new Book(title,date,author,cost);
                        mediaList.add(b);
                    }
                    else
                    {
                        String title = items[1].trim();
                        String date = items[2].trim();
                        double cost = Double.parseDouble(items[3].trim());
                        int issues = Integer.parseInt(items[4].trim());
                        // m,title, date, cost per issue, issues per year
                        Magazine m = new Magazine(title,date,cost,issues);
                        mediaList.add(m);
                    }   
                }
            }
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Media> libraryItems = new ArrayList<>();
        readMedia(libraryItems);
        System.out.println("\nCSIS312 Assignment 1 - Library Program");
        System.out.println("By: Ben Turner & Jack Skywalker (Baijun Jiang)\n");
        System.out.println("\nRead Media\n");
        
        System.out.println("\nTest Interface\n");
        for (Media m : libraryItems)
        {
            MediaUtility mu = m;
            System.out.println(mu.print() + ", Cost: " + mu.getCost());
        }
        
        System.out.println("\nTest Class\n");
        for (Media m : libraryItems)
        {   
            String common = "Title: " + m.getTitle() +
                ", Date: " + m.getPublicationDate() + ", Cost: " + m.getCost();
            if (m instanceof Magazine)
            {                
                System.out.println(common);
            }
            else
            {
                Book b = (Book)m;
                System.out.println(common + ", " + b.getAuthor());
            }            
        }

        System.out.println("\nTest Sorting\n");

        // Library items should sort first by date (earliest to latest)
        // then by title (A-Z)
        Collections.sort(libraryItems);
        for (Media m : libraryItems)
        {
            MediaUtility mu = m;
            System.out.println(mu.print() + ", Cost: " + mu.getCost());
        }
    }
    
}
