import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class WC{
    List<Scanner> scanners;
    String summary;

    public WC() {
        scanners = new ArrayList<Scanner>();
        summary = "";
    }

    public void count(String options){
        for (int i = 0;i < options.length(); i++){
            addScanner(options.charAt(i));
        }
    }

    public void addScanner(char option) {
        if(option == 'l'){
            scanners.add(new LineCount());
        }
        if(option == 'w'){
            scanners.add(new WordCount());
        }
        if(option == 'c'){
            scanners.add(new CharCount());
        }
    }

    public void add(char a) {
        for(Scanner scanner : scanners) {
            scanner.scan(a);
        }
    }

    public String summary(String saprator) {
        for (Scanner scanner: scanners){
            summary += scanner.getCount() + saprator;
        }
        return summary.substring(0, summary.length()-1);
    }

    private static void printOptions(String options, File file)  throws IOException {
        int length = (int) file.length();
        FileReader reader = new FileReader(file);
        char[] data = new char[length];
        reader.read(data, 0, length);
        WC wc = new WC();
        wc.count(options);
        for (char c : data) {
            wc.add(c);
        }
        System.out.println(wc.summary("\t"));
    }

    public static void main(String[] args) throws IOException {
        for (String fileName : args) {
            try {
                File file = new File(fileName);
                printOptions(args[0], file);
            }catch (IOException e){
                System.out.println(fileName + " file not found");
            }
        }
    }
}
