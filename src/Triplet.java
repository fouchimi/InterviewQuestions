/**
 * Created by ousmane on 12/8/16.
 */
public class Triplet {
    private int x, y, z;

    public Triplet(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triplet)) return false;

        Triplet triplet = (Triplet) o;

        if (x != triplet.x) return false;
        if (y != triplet.y) return false;
        return z == triplet.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
