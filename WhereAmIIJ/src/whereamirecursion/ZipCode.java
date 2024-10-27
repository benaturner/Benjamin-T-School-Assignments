package whereamirecursion;

/**
 *
 * @author wschofield
 */
public class ZipCode implements Comparable<ZipCode>
{
    String city;
    String state;
    int zip;

    public ZipCode(String city, String state, int zip)
    {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    // Used to sort the collection
    @Override
    public int compareTo(ZipCode o) {
        if (zip < o.zip)
            return -1;
        else if (zip > o.zip)
            return 1;
        else
            return 0;
    }
    public int getZip() {
        return zip;
    }
}

