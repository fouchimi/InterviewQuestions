import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ousmane on 11/27/16.
 */
public class BiggestPalindrome {

    private HashMap<String, Integer> map = new HashMap<>();

    public String buildPalindrome(String str) {
        String[] strArr = str.split("");
        for(int i= 0; i < strArr.length; i++){
            if(!map.containsKey(strArr[i])){
                map.put(strArr[i], 1);
            }else {
                int val =map.get(strArr[i]);
                val +=1;
                map.put(strArr[i], val);
            }
        }
        Iterator itr = map.entrySet().iterator();
        String firstPart = "";
        String secondPart = "";
        String uniqueKey = "";
        while (itr.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry) itr.next();
            if(pair.getValue() > 1) {
                int i=0;
                for(; i < pair.getValue(); i=i+2){
                    if(pair.getValue() - i > 1) {
                        firstPart = firstPart + pair.getKey();
                        secondPart = pair.getKey() + secondPart;
                    }
                }
                if(pair.getValue()%2 == 1)
                    map.put(pair.getKey(), i-pair.getValue());
                else map.put(pair.getKey(), pair.getValue()-i);
            }
            else {
                uniqueKey = pair.getKey();
                map.put(uniqueKey, pair.getValue()-1);
            }
        }
        return firstPart+ uniqueKey + secondPart;
    }

    public void print(){
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, Integer> pair = (Map.Entry) itr.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }

    public static void main(String[] args){
        BiggestPalindrome bp = new BiggestPalindrome();
        System.out.println(bp.buildPalindrome("aabcbcbdcc"));
        bp.print();
    }
}
