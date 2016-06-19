package pdx.mentor.wordcount.solution;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class WordStatsTest {

    private WordStats wordStats;
    private List<String> simpleWordList;

    @Before
    public void setUp() {
        wordStats = new WordStats();

        simpleWordList = Arrays.asList("one",
                                       "two",
                                       "two",
                                       "three",
                                       "three",
                                       "three",
                                       "four",
                                       "four",
                                       "four",
                                       "four",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven",
                                       "eleven"
                                      );
    }


    @Test
    public void testTotalCount() {
        wordStats.process(simpleWordList.iterator());
        assertEquals("expected different total word count",
                     simpleWordList.size(),
                     wordStats.getTotalWordCount());
    }

    @Test
    public void testCountForWord() {
        wordStats.process(simpleWordList.iterator());

        List<WordCount> expectedList = Arrays.asList(new WordCount("one", 1),
                                                 new WordCount("two", 2),
                                                 new WordCount("three", 3),
                                                 new WordCount("four", 4),
                                                 new WordCount("eleven", 11)
                                                );

        for (WordCount expected : expectedList) {
            WordCount wc = wordStats.countForWord(expected.getWord());
            assertEquals("unexpected word count for " + expected.getWord(), expected.getCount(), wc.getCount());
        }

    }

    @Test
    public void testUniqueWords() {
        wordStats.process(simpleWordList.iterator());

        Set<String> expectedUnique = new HashSet<>(simpleWordList);
        List<WordCount> uniqueWordCounts = wordStats.getWordCounts();

        assertEquals("Unexpected unique word count", expectedUnique.size(), uniqueWordCounts.size());

        Set<String> actualUnique = new HashSet<>();
        for (WordCount wc : uniqueWordCounts) {
            actualUnique.add(wc.getWord());
        }
        assertEquals("Unique word sets don't match", expectedUnique, actualUnique);
    }

}
