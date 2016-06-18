package pdx.mentor.wordcount;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Missing text file argument");
            System.exit(-1);
        }

        File textFile = new File(args[0]);
        Scanner scanner = new Scanner(textFile);

        WordStats wordStats = new WordStats();

        // Scanner implements Iterator<String> ...easy! :-)
        wordStats.process(scanner);


        // Make a defensive copy of the returned list since we immediately modify it
        // Not actually required in this case, but still a good practice
        List<WordCount> uniqueWords = new ArrayList<>(wordStats.getWordCounts());

        // sort using a specific comparator, decorated to compare in revers order
        Collections.sort(uniqueWords,
                         Collections.reverseOrder(WordCount.COMPARE_BY_COUNT));

        for (WordCount wc : uniqueWords) {
            System.out.println(wc.getCount() + "\t" + wc.getWord());
        }
    }

}
