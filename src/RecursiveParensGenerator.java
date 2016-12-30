import java.util.HashSet;
import java.util.Set;

/**
 * Created by ousmane on 12/3/16.
 */
public class RecursiveParensGenerator {

    Set<String> generateParens(int remaining){
        Set<String> set = new HashSet<>();
        if(remaining == 0) {
            set.add("");
        }else{
            Set<String> prev = generateParens(remaining-1);
            for(String str: prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    private String insertInside(String str, int index){
        String left = str.substring(0, index+1);
        String string = str.substring(index+1, str.length());
        return left + "()" + string;
    }

    public static void main(String[] args){
        RecursiveParensGenerator rPG = new RecursiveParensGenerator();
        for(String str : rPG.generateParens(3)){
            System.out.print(str + " ");
        }
    }
}
