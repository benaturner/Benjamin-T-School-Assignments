/* Book class as part of the Library program
 * @author JSWILD
 * @collaborator bent3
 */

package library;

public class Book extends Media {

    // Initialize private instance variables
    private final String author;
    private final double cost;

    // Declare a constructor for Book class
    public Book(String title, String publicationDate, String author, double cost) {
        super(title, publicationDate); // Get variables from superclass
        this.author = author;
        this.cost = cost;
    }

    // Convert Book to specified String format
    public String print() {
        return String.format("Title: %s, Author: %s, Published: %s",
                getTitle(), getAuthor(), getPublicationDate());
    }

    // Access cost value
    public double getCost() {
        return this.cost;
    }

    // Access author data
    public String getAuthor() {
        return this.author;
    }

}
