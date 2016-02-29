public class LineCount implements Scanner {
    private int count;
    public LineCount() {
        this.count = 0;
    }

    public void scan(char character) {
        if (character == '\n')
            this.count++;
    }

    public int getCount() {
        return count;
    }
}
