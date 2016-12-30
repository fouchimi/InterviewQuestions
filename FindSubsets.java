import java.util.ArrayList;

/**
 * Created by ousmane on 12/4/16.
 */
public class FindSubsets {

    public void printAllSubSets(int[]coins, int value){
      printAllSubSets(coins, value, value, "", 0);
    }

    private void printAllSubSets(int[] coins, int value, int target,  String set, int index){
        if(value == 0) {
            set = set.substring(0, set.length()-1);
            String[] values = set.split(",");
            int sum = 0;
            for(String item : values){
                sum += Integer.parseInt(item);
            }
            if(sum == target)
                System.out.println(set);
            return;
        }
        set +=coins[index]+",";
        for(int i=0; i < coins.length; i++){
            if(coins[i] <= value){
                printAllSubSets(coins, value-coins[i], target, set, i);
            }
        }
    }

    public static void main(String[] args){
        FindSubsets fsb = new FindSubsets();
        int[] coins={1, 2, 3};
        int sum = 5;
        fsb.printAllSubSets(coins, sum);
    }
}
