import java.util.ArrayList;

/**
 * Created by ousmane on 12/1/16.
 */
public class NoDupsPermutation {

    public void NoDupsPermutation(String str){
        NoDupsPermutation("", str, new ArrayList<String>());
    }

    private void NoDupsPermutation(String prefix, String str, ArrayList<String> list){
        int n = str.length();
        if(n == 0){
            System.out.println(prefix);
            return;
        }else {
            for(int i=0; i < n; i++){
                if(list.contains(prefix)) continue;
                if(!prefix.contains(""+str.charAt(i))){
                    NoDupsPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list);
                }else {
                    NoDupsPermutation(prefix, str.substring(0, i) + str.substring(i+1, n), list);
                }

            }
        }
        if(!list.contains(prefix)) list.add(prefix);
    }

    public static void main(String[] args){
        NoDupsPermutation pm = new NoDupsPermutation();
        pm.NoDupsPermutation("abdedk");
    }
}
