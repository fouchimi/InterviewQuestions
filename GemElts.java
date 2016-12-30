import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ousmane on 12/19/16.
 */
public class GemElts {

    public int countGems(List<String> list){
        List<HashSet<Character>> lsets = new ArrayList<>();
        for(String str :  list){
            HashSet<Character> newSet = new HashSet<>();
            char[] keys = str.toCharArray();
            for(int i=0; i < keys.length; i++){
                newSet.add(keys[i]);
            }
            lsets.add(newSet);
        }

        HashSet<Character> firstSet = lsets.get(0);
        for(int i=1; i < lsets.size(); i++){
            firstSet.retainAll(lsets.get(i));
        }
        for(Character ch : firstSet){
            System.out.print(ch + " ");
        }
        System.out.println();
        return firstSet.size();
    }


    public static void main(String[] args){
        GemElts gemElts = new GemElts();
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println("Enter " + value + " strings ");
        List<String> list = new ArrayList<>();
        for(int i=0; i < value; i++){
            String str = scanner.next();
            list.add(str);
        }

        System.out.println("The total number of gems elements are: " + gemElts.countGems(list));
    }
}
