import java.util.*;

/**
 * Created by ousmane on 12/20/16.
 */
public class ValidString {


    public int countValidString(String str){
        String string = findValid(str);
        System.out.println("The new String is: " + string + " and the length is: " + string.length());
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i < string.length(); i++){
            set.add(string.charAt(i));
        }
        if(set.size() == 2) return string.length();
        else return 0;
    }

    private String findValid(String str){
        if(str.equals(" ") || str.isEmpty()) return "";
        List<Character> list = new ArrayList<>();
        for(int i=1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)) {
                list.add(str.charAt(i));
            }
        }

        String newString = removeElts(str, list);
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < newString.length(); i++){
            if(!map.containsKey(newString.charAt(i))){
                map.put(newString.charAt(i), 1);
            }else {
                int value = map.get(newString.charAt(i));
                map.put(newString.charAt(i), value+1);
            }
        }
        Iterator itr = map.entrySet().iterator();
        list = new ArrayList<>();
        while(itr.hasNext()){
            Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) itr.next();
            if(pair.getValue() == 1){
                list.add(pair.getKey());
            }
        }
        newString = removeElts(newString, list);
        if(newString.equals(str)) return newString;
        else return findValid(newString);
    }

    private String removeElts(String str, List<Character> list){
        String newString = "";
        for(int i=0; i < str.length(); i++){
            if(!list.contains(str.charAt(i))){
                newString += str.charAt(i);
            }
        }
        return newString;
    }

    public static  void main(String[] args){
        ValidString validString = new ValidString();
        System.out.println(validString.countValidString("beabeefeab"));
    }
}
