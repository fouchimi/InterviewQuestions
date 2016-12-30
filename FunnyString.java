/**
 * Created by ousmane on 12/20/16.
 */
public class FunnyString {

    public void funnyString(String str){
        int i=0, j=str.length()-1;
        boolean flag = false;
        for(; i < j; i++, j--){
            int firstDiff = Math.abs((int)str.charAt(i+1) - (int)str.charAt(i));
            int secondDiff = Math.abs((int) str.charAt(j-1) - (int)str.charAt(j));
            int thirdDiff = Math.abs((int)str.charAt(i)-(int)str.charAt(i+1));
            int fourthDiff = Math.abs((int)str.charAt(j)-(int)str.charAt(j-1));
            if(firstDiff != secondDiff || thirdDiff != fourthDiff) {
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Not funny ...");
        }else {
            int first = Math.abs((int)str.charAt(i) -(int)str.charAt(j));
            int second = Math.abs((int)str.charAt(j) - (int)str.charAt(i));
            if(first != second) System.out.println("Not funny ...");
            else System.out.println("Funny ...");
        }
    }

    public static void main(String[] args){
        FunnyString funnyString = new FunnyString();
        funnyString.funnyString("acxz");
        funnyString.funnyString("bcxz");
    }
}
