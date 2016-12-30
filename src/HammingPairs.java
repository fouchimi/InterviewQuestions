/**
 * Created by ousmane on 12/27/16.
 */
public class HammingPairs {
    public int x;
    public int y;

    public HammingPairs(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof HammingPairs)) return false;
        HammingPairs obj = (HammingPairs) other;
        if((this.x == obj.y && this.y == obj.x) || (this.x == obj.x && this.y == obj.y)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x +"," + this.y +")";
    }
}
