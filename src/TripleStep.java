import java.util.Arrays;

/**
 * Created by ousmane on 12/2/16.
 */
public class TripleStep {

    public int countSteps(int n, int[] memo){
        if(n < 0) return 0;
        if(n == 0) return 1;
        else if(memo[n] > -1){
            return memo[n];
        }
        memo[n] = countSteps(n-3, memo) + countSteps(n-2, memo) + countSteps(n-1, memo);
        return memo[n];
    }

    public static void main(String[] args){
        TripleStep ts = new TripleStep();
        int[] memo = new int[5];
        Arrays.fill(memo, -1);
        System.out.println(ts.countSteps(4, memo));
    }
}
