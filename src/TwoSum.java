/**
 * Created by ousmane on 12/5/16.
 */
public class TwoSum {
    public Point twoSum(int[] nums, int target){
        sort(nums);
        print(nums);
        int sum = 0, lowerIndex = -1, upperIndex = -1;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<=nums.length-1; j++){
                sum = nums[i] + nums[j];
                if(sum == target) {
                    lowerIndex = i;
                    upperIndex = j;
                    return new Point(lowerIndex, upperIndex);
                }else if(sum > target) return null;
            }
        }
        return null;
    }

    private void sort(int[] nums){
        sort(nums, 0, nums.length-1);
    }

    private void print(int[] nums){
        for(int i=0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    private void sort(int[] nums, int start, int end){
        if(start >= end) return;
        else{
            int pIndex = partition(nums, start, end);
            sort(nums, start, pIndex-1);
            sort(nums, pIndex+1, end);
        }
    }

    private int partition(int[] nums, int start, int end){
        int pIndex = start;
        int pivot = nums[end];
        int temp = 0;
        for(int i=start; i<=end-1; i++){
            if(nums[i] <= pivot){
                temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex++;
            }
        }
        temp = nums[pIndex];
        nums[pIndex] = pivot;
        nums[end] = temp;
        return pIndex;
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] arr = {-5, 6, 4, -3, 2, 1, -1};
        int target = 5;
        if((twoSum.twoSum(arr, target)) != null)
            System.out.println(twoSum.twoSum(arr, target));
        int[] nums = {2, 15, 11, 7};
        int sum = 9;
        if((twoSum.twoSum(nums, sum)) != null)
            System.out.print((twoSum.twoSum(nums, sum)));
    }
}
