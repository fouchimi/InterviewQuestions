/**
 * Created by ousmane on 11/27/16.
 */
public class StringInterleaving {

    public void printInterLeaving(String str1, String str2){
        printInterLeavingUtil(str1, str2, 0, 0, "");
    }

    private void printInterLeavingUtil(String str1, String str2, int l1, int l2, String soFar){
        if(l1 == str1.length() && l2 == str2.length()) {
            System.out.println(soFar);
            return;
        }
        if(l1 < str1.length()) {
            printInterLeavingUtil(str1, str2, l1+1, l2, soFar+str1.charAt(l1));
        }

        if(l2 < str2.length()){
            printInterLeavingUtil(str1, str2, l1, l2+1, soFar+str2.charAt(l2));
        }
    }

    public static void main(String[] args){
        StringInterleaving si = new StringInterleaving();
        si.printInterLeaving("abc", "de");
    }
}
