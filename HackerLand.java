/**
 * Created by ousmane on 12/20/16.
 */
public class HackerLand {

    public int minTransmitters(int[] nums, int k){
        quickSort(nums);
        int lim = k, count = 0;
        for(int i=0; i < nums.length; i++){
            if(Math.abs(nums[i]-k) >= lim){
                k = nums[i] + lim;
                count++;
            }
        }
        if(k < nums[nums.length-1]) count++;
        return count;
    }

    private void quickSort(int[] nums){
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end){
        if(start < end){
            int pIndex = partition(nums, start, end);
            quickSort(nums, start, pIndex-1);
            quickSort(nums, pIndex+1, end);
        }
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int pIndex = start, temp=0;
        for(int i = start; i < end; i++){
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

    public static void main(String[] args) {
        HackerLand hackerLand = new HackerLand();
        int[] nums = {7, 2, 4, 6, 5, 9, 12, 11};
        System.out.println("The total number of satellites are: " +  hackerLand.minTransmitters(nums, 2));
        int[] vals = {1, 2, 3, 4, 5};
        System.out.println("The total number of satellites are: " +  hackerLand.minTransmitters(vals, 1));
    }


}
