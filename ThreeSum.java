import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/8/16.
 */
public class ThreeSum {

    public List<Triplet> threeSum(int[] nums){
        nums = insertionSort(nums);
        List<Triplet> list = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                int two_sum = nums[i] + nums[j];
                if(two_sum + nums[k] < 0) {
                    j++;
                } else if(two_sum + nums[k] > 0) k--;
                else {
                    int[] triplet = new int[3];
                    triplet[0] = nums[i];
                    triplet[1] = nums[j];
                    triplet[2] = nums[k];
                    triplet = insertionSort(triplet);
                    Triplet point = new Triplet(triplet[0], triplet[1], triplet[2]);
                    if(!list.contains(point)){
                        list.add(point);
                    }
                    j++;
                    k--;
                }
            }
        }

        for(Triplet triplet : list) {
            System.out.print(triplet + " ");
        }
        return list;
    }

    private int[] insertionSort(int[] nums){
        int N = nums.length;
        for(int i=0; i < N; i++){
            int min = i;
            for(int j=i+1; j < N; j++){
                if(nums[j] < nums[min]) min = j;
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, -1, 0, -4, 2, 1};
        threeSum.threeSum(nums);
    }
}
