import java.util.*;

/**
 * Created by ousmane on 12/8/16.
 */
public class FindAllAnagrams {

    public List<String> findAllAnagrams(String s, String t) {
        HashMap<Character, Integer> textMap = new HashMap<>();
        char[] chars = t.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!textMap.containsKey(chars[i])){
                textMap.put(chars[i], 1);
            }else {
                int value = textMap.get(chars[i]) + 1;
                textMap.put(chars[i], value);
            }
        }
        int i = 0;
        List<String> list = new ArrayList<>();
        while(i < s.length()){
            int count = 0;
            for(int j = i; j < s.length(); j++){
                if(t.contains(s.charAt(j) + "")) {
                    count ++;
                }else {
                    i = j+1;
                    break;
                }
                if(count == t.length()){
                    String currentAnagram = s.substring(i, j+1);
                    HashMap<Character, Integer> anagramMap = new HashMap<>();
                    char[] anagrams = currentAnagram.toCharArray();
                    for(int k=0; k < anagrams.length; k++){
                        if(!anagramMap.containsKey(anagrams[k])){
                            anagramMap.put(anagrams[k], 1);
                        }else{
                            int value = anagramMap.get(anagrams[k]);
                            anagramMap.put(anagrams[k], value+1);
                        }
                    }
                    Iterator it = anagramMap.entrySet().iterator();
                    boolean flag = true;
                    while (it.hasNext()){
                        Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) it.next();
                        char key = pair.getKey();
                        int value = textMap.get(key);
                        if(value != pair.getValue()){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        list.add(currentAnagram);
                        i=j+1;
                    }else i = i+1;
                    break;
                }
            }
        }

        return list;
    }

    public static void main(String[] args){
        FindAllAnagrams faa = new FindAllAnagrams();
        List<String> listOfAll = faa.findAllAnagrams("cbaebabacd", "abc");
        for(String str : listOfAll) {
            System.out.print(str + " ");
        }
    }
}
