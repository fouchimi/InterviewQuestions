/**
 * Created by ousmane on 12/20/16.
 */
public class Pairs {

    public int countPairs(int[] nums, int k){
        int count = 0;
        for(int i=0; i < nums.length; i++){
            for(int j = i+1; j <  nums.length; j++){
                int diff = 0;
                if(nums[j] > nums[i]) {
                    diff = nums[j] - nums[i];
                }else {
                    diff = nums[i] - nums[j];
                }
                if(diff == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Pairs pairs = new Pairs();
        int[] nums = {1,5,3,4,2};
        System.out.println(pairs.countPairs(nums, 2));
    }
}
