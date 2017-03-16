/**
 * Created by shaoshuai on 17/03/2017.
 */
public class Word {
    private String name;
    private int count;

    public Word(String name) {
        this.name = name;
        this.count = 1;
    }

    public void addCount() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name+" "+count;
    }
}
