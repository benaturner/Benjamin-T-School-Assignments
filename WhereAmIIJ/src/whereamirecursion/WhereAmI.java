/*
- I have not discussed the source code in my program with anyone other than my
  instructor’s approved human sources (i.e. programming partner).

- I have not used source code obtained from another student, or any other
  unauthorized source, either modified or unmodified.

- If any source code or documentation used in my program was obtained from
  another source, such as a text book or course notes, that has been clearly
  noted with a proper citation in the comments of my program.

- I have not knowingly designed this program in such a way as to defeat or
  interfere with the normal operation of any machine it is graded on or to produce
  apparently correct results when in fact it does not.
*/
package whereamirecursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Comparator.comparing;

/**
 *
 * @author Benjamin Turner and Jack Skywalker
 */
public class WhereAmI {

    /**
     * 
     * @param zc - Collection of ZipCode objects
     * @param lowIndex - Low index of current range being searched
     * @param highIndex - High index of current range being searched
     * @param lookingFor - zip code being searched for
     * @return - returns the reference of the matching ZipCode object
     * @throws Exception - thrown if zip code entered is not in the collection
     */
    public static ZipCode findZip(List<ZipCode> zc, int lowIndex, int highIndex, int lookingFor) throws Exception {
        
        // Do not remove, this covers the case where the zip code is not in the data set
        if (lowIndex > highIndex) {
            throw new Exception("No entry found for " + lookingFor);
        }
                
        // Might be handy for debug
        //System.out.println("Low: " + lowIndex + " High: " + highIndex);

        // Complete this recursive method to find the right zip code record
        // Note that there are three possibilites
        // 1. Found it, return the record from the ZipCode collection
        // 2. What you're checking is less than what you're looking for. Divide 
        //    the problem and call WhereAmI again
        // 3. What you're checking is more than what you're looking for. Divide 
        //    the problem and call WhereAmI again
                
        // !!!!! NOTE: Every line in the rest of this method must have descriptive
        // comments !!!!!!! Will count off on implementation if not present.

        // your work goes here

        // find the middle index
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;

        // check if the middle index is correct
        if ((zc.get(midIndex)).zip == lookingFor) {
            return zc.get(midIndex);
        }

        // call method again searching the bottom half of the list
        if ((zc.get(midIndex)).zip > lookingFor) {
            return findZip(zc, lowIndex, midIndex - 1, lookingFor);
        }

        // call method again searching the top half of the list
        return findZip(zc, midIndex+1, highIndex, lookingFor);
    }

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // create zipcode list
        List<ZipCode> zips = new ArrayList<>();
        //import data file to a list
        String fileName = "src/whereamirecursion/zipdata.txt";
        List<String> rawData = Files.readAllLines(Paths.get(fileName));

        // puts the relevant data into the zipcode list
        for (String line : rawData) {
            String[] tmp = line.split(",");
            String city = tmp[0];
            String state = tmp[1];
            int zip = Integer.parseInt(tmp[2]);
            ZipCode zc = new ZipCode(city, state, zip);
            zips.add(zc);
        }

        // This sorts the ZipCode list by zip code so that it is in order
        // when you search it. This allows binary search techniques
        
        // Sort the zips list here
        Collections.sort(zips, Comparator.comparingInt(ZipCode::getZip));

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Zip Code (0 to end): ");
            int zipToFind = 0;
            int n = zips.size();
            zipToFind = scan.nextInt();
            // read integer zip code
            if (zipToFind > 0) {
                ZipCode result = null;
                try {
                    // call recursive method here
                    result = findZip(zips, 0, n-1, zipToFind);
                    System.out.println("Found: " + zipToFind + " City: " + result.city
                            + " State: " + result.state);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else
                break;
        }
    }
}
