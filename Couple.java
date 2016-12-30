
/**
 * Created by ousmane on 12/26/16.
 */
public class Couple {
    public char ch;
    public int freq;

    public Couple(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "("+ this.ch +","+ this.freq +")";
    }
}
