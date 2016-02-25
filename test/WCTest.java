import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WCTest {
    @Test
    public void should_calculate_the_word_if_words_are_in_different_lines() {
        WC text = new WC("hello\nbrother");
        assertEquals(2, text.countWords());
    }

    @Test
    public void should_give_0_if_text_is_empty() {
        WC text = new WC("");
        assertEquals(0, text.countWords());
    }

    @Test
    public void should_calculate_the_word_if_words_are_in_same_line() {
        WC text = new WC("Hello brother how are you?");
        assertEquals(5, text.countWords());
    }

    @Test
    public void should_calculate_the_number_count() {
        WC text = new WC("123 4 5 6  7 9");
        assertEquals(6, text.countWords());
    }

    @Test
    public void should_calculate_the_line_count() {
        WC text = new WC("hello\nbrother");
        assertEquals(2, text.countLines());
    }

    @Test
    public void should_give_1_if_there_is_only_one_word() {
        WC text = new WC("hello");
        assertEquals(1, text.countLines());
    }
}
