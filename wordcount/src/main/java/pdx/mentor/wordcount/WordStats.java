package pdx.mentor.wordcount;

import java.util.Iterator;

/**
 * WordStats collects stats supplied from an external word source.
 */
public class WordStats {

    int totalWordCount;

    public void process(Iterator<String> iter) {
        while (iter.hasNext()) {
            String word = iter.next();

            // do something fancier here, like maybe with a Map ;-)
            totalWordCount++;
        }
    }

    public int getTotalWordCount() {
        return totalWordCount;
    }
}
