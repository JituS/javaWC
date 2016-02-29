/**
 * Created by jitendrs on 27/02/16.
 */
public class CharCount implements Scanner {
    private int count;
    @Override
    public void scan(char charactor) {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
