import java.util.HashSet;
import java.util.Set;

/**
 * Created by ousmane on 12/27/16.
 */
public class MaxProductOfWords {

    public int maxProduct(String[] words) {
        int maxProduct = 0;
        HashSet<Character> first = null;
        HashSet<Character> second = null;
        for(int i=0; i < words.length; i++){
            first = new HashSet<>();
            for(Character ch : words[i].toCharArray()){
                first.add(ch);
            }
            for(int j=i+1; j <words.length; j++){
                second = new HashSet<>();
                for(Character ch : words[j].toCharArray()){
                    second.add(ch);
                }
                Set<Character> intersection = new HashSet<>(first);
                intersection.retainAll(second);
                if(intersection.size() > 0) continue;
                else {
                    int product = words[i].length() * words[j].length();
                    if(product > maxProduct) maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args){
        MaxProductOfWords maxProductOfWords = new MaxProductOfWords();
        String[] values = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println("The max product is: " + maxProductOfWords.maxProduct(values));
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println("The max product is: " + maxProductOfWords.maxProduct(words));
        String[] vals = {"a", "aa", "aaa", "aaaa"};
        System.out.println("The max product is: " + maxProductOfWords.maxProduct(vals));
    }
}
