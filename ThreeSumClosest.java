import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/8/16.
 */
public class ThreeSumClosest {
    public List<Triplet> threeSumClosest(int[] nums, int target){
        int min_gap = Integer.MAX_VALUE;
        List<Triplet> list = new ArrayList<>();
        Triplet finalTriplet = null;
        nums = sort(nums);
        for(int i=0; i < nums.length; i++){
            int j = i+1;
            int k = nums.length -1;
            while(j < k){
                int two_sum = nums[i] + nums[j];
                int three_sum = two_sum + nums[k];
                int steps = 0;
                if(three_sum < 0) {
                    steps = target - three_sum;
                    if(steps < min_gap) {
                        min_gap = steps;
                        finalTriplet = new Triplet(nums[i], nums[j], nums[k]);
                    }
                    j++;
                }
                else if(three_sum > 0){
                    steps = three_sum - target;
                    if(steps < min_gap) {
                        min_gap = steps;
                        finalTriplet = new Triplet(nums[i], nums[j], nums[k]);
                    }
                    k--;
                }else {
                    j++;
                    k--;
                    list.add(new Triplet(nums[i], nums[j], nums[k]));
                    return list;
                }
            }
        }
        list.add(finalTriplet);
        System.out.println("Final triplet: " + finalTriplet);
        return list;
    }

    private int[] sort(int[] nums){
        for(int i=0; i < nums.length; i++){
            int min = i;
            for(int j=i+1; j < nums.length; j++){
                if(nums[j] < nums[min]) min = j;
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args){
        ThreeSumClosest thsc = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        thsc.threeSumClosest(nums, 1);
    }
}
