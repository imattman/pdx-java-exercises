package pdx.mentor.wordcount;

import java.util.Comparator;

/**
 * A composite class for grouping a word with its count (and possibly other stats).
 */
public class WordCount implements Comparable<WordCount> {

    /** Comparator for comparing numerically by word count */
    public static Comparator<WordCount> COMPARE_BY_COUNT = new ByCountComparator();

    private String word;
    private int count;

    public WordCount(final String word, final int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }

    @Override
    public int compareTo(final WordCount o) {
        // default is lexiographic sort by word
        return this.word.compareTo(o.word);
    }


    private static class ByCountComparator implements Comparator<WordCount> {
        @Override
        public int compare(final WordCount o1, final WordCount o2) {
            // compare by count
            int cmp = o1.count - o2.count;

            if (cmp == 0) {
                // fall back to natural ordering
                cmp = o1.compareTo(o2);
            }

            return cmp;
        }
    }

}
