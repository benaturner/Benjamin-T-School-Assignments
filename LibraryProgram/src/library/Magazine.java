/* Magazine class as part of the Library program
 * @author bent3
 * @collaborator JSWILD
 */

package library;

public class Magazine extends Media {

    // Initialize private instance variables
    private final double issueCost;
    private final int issuesPerYear;

    // Declare a constructor for Magazine class
    public Magazine(String title, String publicationDate, double issueCost, int issues) {
        super(title, publicationDate); // Get variables from superclass
        this.issueCost = issueCost;
        this.issuesPerYear = issues;
    }

    // Convert Magazine to specified String format
    public String print() {
        return String.format("Title: %s, Date: %s, Issues: %d",
                getTitle(), getPublicationDate(), this.issuesPerYear);
    }

    // Access and compute cost data
    public double getCost() {
        return (double)this.issuesPerYear * this.issueCost;
    }

}
