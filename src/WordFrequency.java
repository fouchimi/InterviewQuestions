import java.util.*;

/**
 * Created by ousmane on 12/27/16.
 */
public class WordFrequency {

    public void sortByFrequency(String str){
        String[] chunks = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String chunk : chunks){
            if(!map.containsKey(chunk)){
                map.put(chunk, 1);
            }else {
                int freq = map.get(chunk);
                map.put(chunk, freq+1);
            }
        }
        Iterator itr = map.entrySet().iterator();
        Tuple[] tuples = new Tuple[map.size()];
        int i=0;
        while(itr.hasNext()){
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) itr.next();
            tuples[i++] = new Tuple(pair.getKey(), pair.getValue());
        }

        Arrays.sort(tuples, new TupleCompartor());
        for(Tuple tuple : tuples){
            System.out.println(tuple);
        }
    }

    private class TupleCompartor implements Comparator<Tuple>{

        @Override
        public int compare(Tuple firstTuple, Tuple secondTuple) {
            if(firstTuple.freq < secondTuple.freq) return 1;
            else if(firstTuple.freq > secondTuple.freq) return -1;
            else return 0;
        }
    }

    public static void main(String[] args){
        WordFrequency wordFrequency = new WordFrequency();
        String sentence = "the day is sunny the the the sunny is is";
        wordFrequency.sortByFrequency(sentence);
    }
}
