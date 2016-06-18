package pdx.mentor.wordcount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * WordStats collects stats supplied from an external word source.
 */
public class WordStats {

    private Map<String, Integer> wordCounts = new HashMap<>();


    public WordStats() {
    }


    public void process(Iterator<String> iter) {
        while (iter.hasNext()) {
            String word = iter.next();

            // Note: Java 8 makes this easier with Map#computeIfAbsent
            int count = wordCounts.containsKey(word) ?
                        wordCounts.get(word) :
                        0;
            count++;

            wordCounts.put(word, count);
        }
    }

    public WordCount countForWord(String word) {
        if (!wordCounts.containsKey(word)) {
            return new WordCount(word, 0);
        }

        return new WordCount(word, wordCounts.get(word));
    }

    public List<WordCount> getWordCounts() {
        List<WordCount> counts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            counts.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        return counts;
    }

    public int getTotalWordCount() {
        // note: Java 8 makes this easier
        int total = 0;
        for (int count : wordCounts.values()) {
            total += count;
        }

        return total;
    }
}
