package pdx.mentor.wordcount;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


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
                                       "three");
    }


    @Test
    public void testTotalCount() {
        wordStats.process(simpleWordList.iterator());
        assertEquals("expected different total word count",
                     simpleWordList.size(),
                     wordStats.getTotalWordCount());
    }
}
