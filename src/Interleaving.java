/**
 * Created by ousmane on 12/12/16.
 */
public class Interleaving {

    public void interleaving(String str1, String str2, int m, int n, char[] str, int index){
        if(m == str1.length() && n == str2.length()) {
            System.out.println(String.valueOf(str));
        }
        if(m != str1.length()){
            str[index] = str1.charAt(m);
            interleaving(str1, str2, m+1, n,  str, index+1);
        }

        if(n != str2.length()){
            str[index] = str2.charAt(n);
            interleaving(str1, str2, m, n+1, str, index+1);
        }
    }

    public static void main(String[] args){
        Interleaving obj = new Interleaving();
        String first = "ab";
        String second = "cde";
        char[] str = new char[first.length() + second.length()];
        obj.interleaving(first, second, 0, 0,  str, 0);
    }
}
