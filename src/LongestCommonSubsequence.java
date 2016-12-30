import java.util.Stack;

/**
 * Created by ousmane on 12/13/16.
 */
public class LongestCommonSubsequence {

    public void lcs(String str1, String str2){
        char[] first = str1.toCharArray();
        char[] second = str2.toCharArray();
        lcs(first, second);
    }

    private void lcs(char[] first, char[] second){
        int[][] result = new int[first.length + 1][second.length+1];
        int max = Integer.MIN_VALUE;
        int row = 0;
        for(int i=1; i < result.length; i++) {
            for(int j=1; j < result[0].length; j++){
                if(first[i-1] == second[j-1]) {
                    result[i][j] = result[i-1][j-1] + 1;
                }else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
                if(result[i][j] > max) {
                    max = result[i][j];
                    row = i;
                }
            }
        }

        for(int i=0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

        Stack<Character> stack = new Stack<>();
        for(int i=result.length; i > 0; ) {
            
        }
    }

    public static void main(String[] args){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.lcs("acbcf", "abcdaf");
    }
}
