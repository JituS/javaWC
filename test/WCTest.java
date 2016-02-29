import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class WCTest {
    @Test
    public void wordCount_be_1__if_text_is_a_single_word() {
        WC wc = new WC();
        wc.count("w");
        wc.add('a');
        wc.add('b');
        assertEquals("1", wc.summary("\t"));
    }

    @Test
    public void should_calculate_the_word_if_words_are_in_different_lines() throws Exception {
        WC wc = new WC();
        wc.count("w");
        wc.add('a');
        wc.add('b');
        wc.add(' ');
        wc.add('d');
        assertEquals("2", wc.summary("\t"));
    }

    @Test
    public void should_calculate_the_word_and_lines() throws Exception {
        WC wc = new WC();
        wc.count("wl");
        wc.add('a');
        wc.add('b');
        wc.add('\n');
        wc.add(' ');
        wc.add('d');
        assertEquals("2\t1", wc.summary("\t"));
    }
    @Test
    public void should_calculate_the_word_lines_and_chars() throws Exception {
        WC wc = new WC();
        wc.count("wlc");
        wc.add('a');
        wc.add('b');
        wc.add('\n');
        wc.add(' ');
        wc.add('d');
        assertEquals("2\t1\t5", wc.summary("\t"));
    }

    @Test
    public void should_give_0_if_text_is_empty() {
        WC wc = new WC();
        wc.count("c");
        wc.add('a');
        wc.add('b');
        wc.add(' ');
        wc.add('d');
        assertEquals("4", wc.summary("\t"));
    }
    @Test
    public void should_give_2_if_text_has_tab_as_delimiter() {
        WC wc = new WC();
        wc.count("w");
        wc.add('a');
        wc.add('b');
        wc.add('\t');
        wc.add('d');
        assertEquals("2", wc.summary("\t"));
    }
}
