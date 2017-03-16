import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by shaoshuai on 16/03/2017.
 */
public class WordsProcessorTest {


    @Test
    public void test_given_null_word_then_be_ok() {
        String word = "";
        String result = WordsProcessor.process(word);
        assertThat(result).isEqualTo("");
    }

    @Test
    public void test_given_space_2_word_then_split_ok() {
        String word = "the one";
        String result = WordsProcessor.process(word);
        assertThat(result).isEqualTo("the 1 \n one 1");
    }

    @Test
    public void test_given_space_repeat_word_then_group_ok() {
        String word = "the one one";
        String result = WordsProcessor.process(word);
        assertThat(result).isEqualTo("one 2 \n the 1");
    }

    @Test
    public void test_given_multiple_space_then_group_ok() {
        String word = "the   one one";
        String result = WordsProcessor.process(word);
        assertThat(result).isEqualTo("one 2 \n the 1");
    }

}