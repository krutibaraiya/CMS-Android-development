package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Set of utility functions that can be used throughout the entire project.
 *
 * Created by abhijeetviswa 21/04/2019
 */
public class Util {

    /**
     * Start from <code>start</code> and finds the next word. A word is a sequence of 4 or more characters that ends with a whitespace or a newline.
     * @param str The string in which you want to find the next word
     * @param start The index position starting from which the next word is to be found
     * @return
     */
    public static String nextNearestWord(String str, int start)
    {
        boolean foundWord = false;
        int i = start, t = -1;
        while (!foundWord)
        {
            if (i >= str.length()) break; /* We didn't find any word :( */

            char ch = str.charAt(i);
            if (ch != '\n' && ch != ' ') {
                if (t == -1) t = i;
                i++;
            }
            else if (i != start && t != -1)
            {
                if ((i - t)  >= 4)
                    foundWord = true;
                else {
                    i++;
                    t = -1;
                }
            }else i++;
        }
        if (foundWord) return str.substring(t, i);
        else return ""; /* We probably started at the end of the string */
    }

    /**
     * Counts the number of occurrences of <code>word</code> in <code>str</code>
     * @param str The string in which you want to search
     * @param word The word whose occurrence count you want
     * @return an integer representing the number of occurrences
     */
    public static int countOccurrencesOfWord(String str, String word)
    {
        int count = 0, startIndex = 0;
        while ((startIndex = str.indexOf(word, startIndex)) != -1)
        {
            count++;
            startIndex++;
        }

        return count;
    }

    /**
     * Gets the index of the nth occurrence of  <code>word</code> in <code>str</code>
     * If the word doesn't occur a minimum of n times, -1 is returned
     * @param str
     * @param word
     * @param n
     * @return an integer representing the index of the nth occurrence, else -1
     */
    public static int indexOfOccurrence(String str, String word, int n)
    {
        if (n <= 0) throw new IllegalArgumentException("n should be an integer greater than or equal to 1");

        int count = 0, startIndex = 0;
        while ((startIndex = str.indexOf(word, startIndex)) != -1)
        {
            count++;
            if (count == n) break; /* We have found the nth occurrence */
            startIndex++;
        }

        if (count != n) return -1; /* There weren't n occurrences */
        return startIndex;
    }


    /**
     * Convert `bytes` to human readable format
     * Sourced from: https://stackoverflow.com/a/3758880/2198399
     * @param si use SI or binary units
     * @return Human-readable size in SI/binary units
     */
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }


    /**
     * Constructs a DateTime string in the local timezone
     * @param epoch Unix epoch of the instant, in seconds
     * @return DateTime string in the format 10:10:10 AM 18-Nov-2019
     */
    public static String epochToDateTime(long epoch) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:m:ss a dd-MMM-yy");
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(new Date(epoch * 1000));
    }

}
