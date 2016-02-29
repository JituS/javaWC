import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount implements Scanner {
    private int count;

    public WordCount() {
        this.count = 0;
    }

    public int getCount() {
        return count + 1;
    }

    @Override
    public void scan(char character) {
        Pattern pattern = Pattern.compile("[\t]|[ ]");
        Matcher matcher = pattern.matcher(character+"");
        if (matcher.find()) {
            count++;
        }
    }
}
