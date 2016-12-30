/**
 * Created by ousmane on 12/26/16.
 */
public class CountSegments {

    public int count(String str){
        int count = 0;
        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) == ' ') count++;
        }
        return count+1;
    }

    public static void main(String[] args){
        CountSegments cs = new CountSegments();
        String str = "Hello, my name is John";
        System.out.println(cs.count(str));
    }
}
