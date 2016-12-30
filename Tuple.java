/**
 * Created by ousmane on 12/27/16.
 */
public class Tuple {

    public int key;
    public int val;
    public String keyString;
    public int freq;

    public Tuple(int key, int val){
        this.key = key;
        this.val = val;
    }

    public Tuple(String keyString, int freq){
        this.keyString = keyString;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "" + keyString + " " + freq;
    }

}
