import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/27/16.
 */
public class HammingDistance {

    public int hammingDistance(int[] nums){
        List<HammingPairs> list = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            for(int j=0; j < nums.length; j++){
                if(i != j){
                    HammingPairs pair = new HammingPairs(nums[i], nums[j]);
                    if(!list.contains(pair)){
                        list.add(pair);
                    }else continue;
                }
            }
        }

        int count = 0;
        for(HammingPairs pair : list){
            System.out.print(pair + " ");
            count += computeHammingDistance(pair.x, pair.y);
        }
        return count;
    }

    private int computeHammingDistance(int x, int y){
        int count =0;
        int val = (x ^ y);
        int N = val;
        while(N > 0){
            int value = (N & 1);
            if(!(value%2 == 0)) count++;
            N /=2;
        }
        return count;
    }

    public static void main(String[] args){
        HammingDistance hd = new HammingDistance();
        int[] nums = {4, 14, 2};
        int answer = hd.hammingDistance(nums);
        System.out.println("\nThe minimum hamming distance is: " + answer);
    }
}
