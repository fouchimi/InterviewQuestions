/**
 * Created by ousmane on 12/20/16.
 */
public class MinNumDel {

    public int minNumDel(String str){
        if(str.length() == 1) return  0;
        else if(str.length() == 2){
            if(str.charAt(0) != str.charAt(1)) return 0;
            else return 1;
        }else {
            int i=1, j=0;
            String answer ="";
            answer += str.charAt(0);
            for(; i < str.length(); i++){
                if(answer.charAt(j) != str.charAt(i)) {
                    answer += str.charAt(i);
                    j++;
                }
            }

            return str.length() - answer.length();
        }
    }

    public static void main(String[] args){
        MinNumDel minNumDel = new MinNumDel();
        System.out.println(minNumDel.minNumDel("AAAA"));
        System.out.println(minNumDel.minNumDel("BBBBB"));
        System.out.println(minNumDel.minNumDel("ABABABAB"));
        System.out.println(minNumDel.minNumDel("BABABA"));
        System.out.println(minNumDel.minNumDel("AAABBB"));
    }
}
