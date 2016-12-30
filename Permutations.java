import java.util.ArrayList;

/**
 * Created by ousmane on 11/22/16.
 */
public class Permutations {

    public void permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        permutation("", str, list);
    }

    private void permutation(String prefix, String str, ArrayList<String> list){
        int n = str.length();
        if(n == 0) {
            System.out.println(prefix);
        }else {
            for(int i=0; i < n; i++) {
                if(list.contains(prefix)) continue;
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list);
            }
        }

        if(!list.contains(prefix)) list.add(prefix);
    }

    public static void main(String[] args){
        Permutations obj = new Permutations();
        long startTime = System.nanoTime();
        obj.permutation("abc");
        long endTime = System.nanoTime();
        long duration = (endTime-startTime);
        System.out.println((duration/1000000) + " ms");
    }
}
