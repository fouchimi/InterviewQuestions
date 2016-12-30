import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ousmane on 12/26/16.
 */
public class SortByFreq {

    public void sortDecreasing(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < str.toCharArray().length; i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else {
                int freq = map.get(ch);
                map.put(ch, freq+1);
            }
        }
        Iterator itr = map.entrySet().iterator();
        Couple[] couples = new Couple[map.size()];
        int i=0;
        while (itr.hasNext()){
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            couples[i] = new Couple(pair.getKey(), pair.getValue());
            i++;
        }
        for(Couple couple: couples){
            System.out.print(couple);
        }
        System.out.println();
        Arrays.sort(couples, new LexicographicComparator());
        for(Couple couple: couples){
            System.out.print(couple);
        }
        System.out.println();
        Arrays.sort(couples, new FrequencyComparator());
        for(Couple couple: couples){
            System.out.print(couple);
        }
        System.out.println();
        String result = "";
        for(Couple couple : couples){
            int N = couple.freq;
            while(N > 0){
                result += couple.ch;
                N--;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){
        SortByFreq sortByFreq = new SortByFreq();
        sortByFreq.sortDecreasing("tree");
        sortByFreq.sortDecreasing("cccaaa");
        sortByFreq.sortDecreasing("Aabb");
    }
}
