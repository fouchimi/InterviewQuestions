import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ousmane on 11/14/16.
 */
public class SortWords {
    private static HashMap<Integer, String> map = new HashMap<>();

    private static String sortString(String str){
        String[] strArray = str.split(" ");
        for(int i=1; i<=9; i++){
            map.put(i, "");
        }
        for(String word : strArray){
            Iterator itr = map.entrySet().iterator();
            while(itr.hasNext()){
                Map.Entry pair = (Map.Entry) itr.next();
                int index = (Integer) pair.getKey();
                if(word.contains("" + index)){
                    map.put((Integer) pair.getKey(), word);
                }
            }
        }
        Iterator itr = map.entrySet().iterator();
        String result = "";
        while(itr.hasNext()){
            Map.Entry pair = (Map.Entry) itr.next();
            result +=  String.valueOf(pair.getValue()) + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SortWords.sortString("is2 Thi1s T4est 3a"));
    }
}
