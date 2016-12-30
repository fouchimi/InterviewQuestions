import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by ousmane on 12/25/16.
 */
public class Quadruple {
    private int w, x, y, z;

    public Quadruple(int w, int x, int y, int z){
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof Quadruple)) return false;
        Quadruple obj = (Quadruple) other;
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();
        first.add(this.w);
        first.add(this.x);
        first.add(this.y);
        first.add(this.z);
        second.add(obj.w);
        second.add(obj.x);
        second.add(obj.y);
        second.add(obj.z);
        Set<Integer> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer val : first){
            if(!map.containsKey(val)){
                map.put(val, 1);
            }
        }
        for(Integer val : second){
            if(!map.containsKey(val)){
                map.put(val, 1);
            }
        }
        if(!intersection.isEmpty() && intersection.size() == map.size()) return false;
        return true;
    }
}
