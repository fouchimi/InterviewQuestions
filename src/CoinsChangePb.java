
/**
 * Created by ousmane on 12/3/16.
 */
public class CoinsChangePb {

    public int countPossibleChange(int v, int[] coins){
        int sum = countPossibleChange(v, coins, 0);
        return sum;
    }

    private int countPossibleChange(int v, int[] coins, int index){
        if(v < 0) return 0;
        if(v == 0) {
            System.out.println();
            return 1;
        }
        if(index == coins.length && v > 0) return 0;
        return countPossibleChange(v-coins[index], coins, index) +
                countPossibleChange(v, coins, index+1);
    }

    public static void main(String[] args){
        CoinsChangePb cpb = new CoinsChangePb();
        int[] coins = {1,2,3};
        int value = 5;
        System.out.println(cpb.countPossibleChange(value, coins));
    }
}
