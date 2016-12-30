import java.util.HashMap;


/**
 * Created by ousmane on 12/5/16.
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int N = s.length();
        String result = "";
        String longest= "";
        if(s.length() == 1) {
            System.out.println("The longest substring is: " + s);
            return s.length();
        }else {
            while (N > 1){
                String substr = "";
                for(int i=0; i < N; i++){
                    if(!map.containsKey(s.charAt(i))){
                        substr += s.charAt(i);
                        map.put(s.charAt(i), 1);
                    }else {
                        s = s.substring(i, s.length());
                        break;
                    }
                }
                if(substr.length() > result.length()){
                    result = substr;
                }
                map = new HashMap<>();
                N = s.length();
            }
            System.out.println("The longest substring is: " + result);
            return result.length();
        }
    }

    public static void main(String[] args){
        LongestSubString lsbtr = new LongestSubString();
        System.out.println(lsbtr.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lsbtr.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lsbtr.lengthOfLongestSubstring("pwwkew"));
    }
}
