/* Media class as part of the Library program
 * @author bent3
 * @collaborator JSWILD
 */

package library;

public abstract class Media implements Comparable<Media>, MediaUtility {

    // Declare protected instance variables
    protected String title;
    protected String publicationDate;

    // Constructor for media class
    public Media(String title, String publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    // CompareTo method for sorting by date then title
    public int compareTo(Media m) {
        int dateComparition = this.getPublicationDate().compareTo(m.getPublicationDate());
        int titleComparition = this.getTitle().compareTo(m.getTitle());

        if (dateComparition == 0) {
            if (titleComparition > 0)
                return 1;
            else if (titleComparition < 0)
                return -1;
            else
                return 0;
        }
        return dateComparition;
    }

    // Access title data
    public String getTitle() {
        return title;
    }

    // Access publicationDate data
    public String getPublicationDate() {
        return publicationDate;
    }

    // Declare abstract getCost method
    public abstract double getCost();

    // Declare abstract print method
    public abstract String print();

}
