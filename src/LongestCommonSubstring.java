import java.util.Stack;

/**
 * Created by ousmane on 12/13/16.
 */
public class LongestCommonSubstring {

    public int longestCommonSubString(String str1, String str2){
        char[] first = str1.toCharArray();
        char[] second = str2.toCharArray();
        return longestCommonSubString(first, second);
    }

    private int longestCommonSubString(char[] str1, char[] str2){
        int[][] result = new int[str1.length+1][str2.length+1];
        int max = Integer.MIN_VALUE;
        int row = 0;
        for(int i=0; i < str1.length; i++){
            for(int j=0; j < str2.length; j++){
                if(i == 0 || j == 0){
                    result[i][j] = 0;
                }else if(str1[i] == str2[j]) {
                    result[i][j] = result[i-1][j-1] + 1;
                    if(result[i][j] > max) {
                        max = result[i][j];
                        row = i;
                    }
                }else {
                    result[i][j] = 0;
                }
            }
        }

        for(int i=0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        Stack<Character> stack = new Stack<>();

        for(int i=row; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if(i == 0 && j==0) break;
                stack.push(str2[j]);
                break;
            }
        }
        String substr = "";
        while(!stack.isEmpty()){
            substr += stack.pop();
        }
        System.out.println("The longest common substring is: " + substr);
        return substr.length();
    }

    public static void main(String[] args){

        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.longestCommonSubString("abcdaf", "zbcdf");
    }
}
