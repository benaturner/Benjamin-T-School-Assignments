package analyzer;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Benjamin Turner and Jack Skywalker
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 *
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 *
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 *
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */
public class TextAnalysis
{

    /**
     * Returns the Flesch Reading Ease Level
     *
     * @param words - total words in document
     * @param sentences - total sentences
     * @param syllables - total syllables
     * @return
     */
    public static int getReadingEase(int words, int sentences, int syllables)
    {
        return (int) (Math.round(206.835 - 1.015 * words / sentences - 84.6
            * syllables / words));
    }

    /**
     * Returns the Flesch Reading Ease Level Text Description
     *
     * @param words - total words in document
     * @param sentences - total sentences
     * @param syllables - total syllables
     * @return
     */
    public static String getReadingEaseText(int words, int sentences, int syllables)
    {
        int score = getReadingEase(words, sentences, syllables);
        if (score >= 0 && score <= 30)
        {
            return score + " or College Graduate";
        }
        else if (score > 30 && score <= 50)
        {
            return score + " or College";
        }
        else if (score > 50 && score <= 60)
        {
            return score + " or 10th to 12th grade";
        }
        else if (score > 60 && score <= 70)
        {
            return score + " or 8th to 9th grade";
        }
        else if (score > 70 && score <= 80)
        {
            return score + " or 7th grade";
        }
        else if (score > 80 && score <= 90)
        {
            return score + " or 6th grade";
        }
        else
        {
            return score + " or 5th grade";
        }
    }

    /**
     * Returns the total word count
     * @param text to be analyzed
     * @return count of words
     */
    public static int getWordCount(String text)
    {
        return getWords(text).length;
    }

    /**
     * Returns an array of the words
     * @param text to be used
     * @return String[] of words
     */
    public static String[] getWords(String text)
    {
        // remove punctuation
        String noPuncText = text.replaceAll("[.?!,;'():]", "");
        // return an array of strings with each element being a word in the original string
        return noPuncText.split(" ");
    }

    // Add method to count the sentences
    public static int getSentenceCount(String text)
    {
        // creates a variable to count the number of sentences
        int numSentences = 0;
        // creates an array defining the different punctuation that ends a sentence
        char[] punctuation = {'.', '?', '!'};
        // gets the last character of the string
        String lastChar = text.substring(text.length() - 1);
        // checks if the last character is not a punctuation and increases the number of sentences accordingly
        if (!(new String(punctuation).contains(lastChar))) {
            numSentences++;
        }
        // counts the number of times the punctuation appears in the text. Does not consider ... or 1.0
        numSentences = numSentences + countCharacters(text, punctuation);
        // returns sentence count
        return numSentences;
    }

    /**
     * Returns the average length of a sentence in words.
     * @param text - text to be analyzed
     * @return - average limited to two decimal places precision
     */
    public static double getAverageSentenceLength(String text)
    {
        double rval = (double) getWordCount(text) / getSentenceCount(text);
        Double truncatedDouble = BigDecimal.valueOf(rval)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
        return truncatedDouble;
    }

    /**
     * Helper method to count particular characters
     *
     * @param text - string of text to search
     * @param characters[] - array of characters to search for
     * @return - number of matching characters in the string
     */
    private static int countCharacters(String text, char[] characters)
    {
        int count = 0;
        for (int i = 0; i < text.length(); i++)
        {
            for (int j = 0; j < characters.length; j++)
            {
                if (text.charAt(i) == characters[j])
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Calculates the Gunning Fog Readability Index
     * @param text - text to be analyzed
     * @return - rounded index
     *
     */
    public static double gunningFogIndex(String text)
    {
        // Get complex words
        int complex = 0;
        String[] words = getWords(text);
        for (String word : words)
        {
            if (getSyllableCount(word, true) >= 3)
            {
                complex++;
            }
        }
        double gfx = 0.4 * (getAverageSentenceLength(text) + 100
            * complex / getWordCount(text));
        return Math.round(gfx);
    }

    /**
     * Returns a string indicating the level of the Gunning Fog Index
     * @param text - text to be analyzed
     * @return 
     */
    public static String gunningDescription(String text)
    {
        int gfx = (int) gunningFogIndex(text);
        switch (gfx)
        {
            case 6:
                return "6th Grade";
            case 7:
                return "7th Grade";
            case 8:
                return "8th Grade";
            case 9:
                return "High school freshman";
            case 10:
                return "High school sophomore";
            case 11:
                return "High school junior";
            case 12:
                return "High school senior";
            case 13:
                return "College freshman";
            case 14:
                return "College sophomore";
            case 15:
                return "College junior";
            case 16:
                return "College senior";
            case 17:
                return "College graduate";
            default:
                return "Unknown index";
        }
    }

    /**
     * Returns the average syllable count per word
     * @param text to be analyzed
     * @return average syllable rounded to two decimal places
     */
    public static double getAverageSyllables(String text)
    {
        // count the number of words
        double numWords = getWordCount(text);
        // count the number of syllables
        double numSyllables = getSyllableCount(text, false);
        // divide the total number of syllables by the total number of words
        double average = numSyllables/numWords;
        // round to two decimals
        return Math.round(average * 100.0) / 100.0;
    }

    /**
     * Counts the syllables in a block of text
     *
     * @param gunning - call with value of true for Gunning Fog calculation
     * @param text - text to be analyzed
     * @return - syllable count
     */
    // this is missing some exceptions. Notably, it counts "file" as one syllable and does not take into account that the letter "y" sometimes behaves like a vowel.
    public static int getSyllableCount(String text, boolean gunning)
    {
        int count = 0;
        char[] vowels =
        {
            'a', 'e', 'i', 'o', 'u'
        };
        String[] endings =
        {
            "es", "ed", "e"
        };
        String[] doubleVowels =
        {
            "oo", "ee"
        };
        String lowerText = text.toLowerCase();
        String[] words = lowerText.split(" ");
        for (String word : words)
        {
            // Assume each vowel corresponds to a syllable
            count += countCharacters(word, vowels);
            // Offset for double vowels
            for (String db : doubleVowels)
            {
                if (word.contains(db))
                {
                    count -= 1;
                }
            }
            // Account for es, ed, e
            for (String ending : endings)
            {
                if (word.endsWith(ending))
                {
                    count -= 1;
                }
                if (gunning && word.endsWith("ing"))
                {
                    count -= 1;
                }
            }
            // Add back in syllable for words that ended in "le"
            if (word.endsWith("le"))
            {
                count += 1;
            }
        }
        return count;
    }
}
