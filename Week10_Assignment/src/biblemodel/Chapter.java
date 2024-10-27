/*  Integrity pledge
a.	I have not shared the source code in my program with anyone other than my 
    instructor’s approved human sources.
b.	I have not used source code obtained from another student, or any other 
    unauthorized source, either modified or unmodified.
c.	If any source code or documentation used in my program was obtained from 
    another source, such as a text book or course notes, that has been clearly
    noted with a proper citation in the comments of my program.
d.	I have not knowingly designed this program in such a way as to defeat or 
    interfere with the normal operation of any machine it is graded on or to produce 
    apparently correct results when in fact it does not.
 */

package biblemodel;

import java.util.ArrayList;

/**
 *
 * @author wschofield
 */
public class Chapter
{
    private final String id;
    private final ArrayList<Verse> verses;
    
    public Chapter(String id)
    {
        this.id = id;
        verses = new ArrayList<>();
    }
    
    public void addVerse(Verse v)
    {
        getVerses().add(v);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(System.lineSeparator());
        for (Verse v : getVerses())
        {
            sb.append(v.toString());
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
    public ArrayList<Verse> getVerses()
    {
        return verses;
    }
}