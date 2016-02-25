import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WC {
    String text;
    String fileName;
    int charLength;

    public WC(String fileText) {
        this.text = fileText;
    }

    public WC(String fileName, String fileText, int length) {
        this.text = fileText;
        this.charLength = length;
        this.fileName = fileName;
    }

    public int countLines() {
        String pattern = "\n";
        Pattern p = Pattern.compile(pattern);
        return p.split(this.text).length;
    }

    public int countWords() {
        String pattern = "[\\S]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(this.text);
        int count = 0;
        while (m.find()) {
            ++count;

        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        int length = (int) file.length();
        FileReader reader = new FileReader(file);
        char[] data = new char[length];
        reader.read(data, 0, length);
        String str = new String(data);
        WC wc = new WC(args[0], str, length);
    }
}