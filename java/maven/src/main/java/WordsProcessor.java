
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Stream;

public class WordsProcessor {

    public static final String EMPTY = "";

    public static String process(String word) {
        if (EMPTY.equals(word)) {
            return EMPTY;
        }
        String[] splitWord = word.split("\\s+");
        Collection<Word> groupWords = groupWords(splitWord);
        ArrayList<Word> words = sortWords(groupWords);
        return Joiner.on(" \n ").join(words).toString();
    }

    private static ArrayList<Word> sortWords(Collection<Word> words) {
        Stream<Word> sorted = words.stream().sorted((o1, o2) -> o2.getCount() - o1.getCount());
        return Lists.newArrayList(sorted.iterator());
    }

    private static Collection<Word> groupWords(String[] splitWord) {
        HashMap<String, Word> result = new HashMap<>();
        for (String w : splitWord) {
            if (result.containsKey(w)) {
                Word word = result.get(w);
                word.addCount();
                continue;
            }
            result.put(w, new Word(w));
        }
        return result.values();
    }

}
