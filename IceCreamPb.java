/**
 * Created by ousmane on 12/20/16.
 */
public class IceCreamPb {

    public void findExactExpense(int[] nums, int k){
        quickSort(nums);
        int i=0, index = 0;
        boolean flag = false;
        for(; i < nums.length; i++){
            int rem = k - nums[i];
            if(rem > 0){
                index = binarySearch(nums, i+1, nums.length-1, rem);
                if(index != -1) {
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(nums[i] + ", " + nums[index]);
        }else {
            System.out.println("Couldn't find the exact flavors");
        }
    }

    private int binarySearch(int[] nums, int start, int end, int key){
        if(start > end) return -1;
        int mid = start + (end-start)/2;
        if(nums[mid] == key) return mid;
        else if(key < nums[mid]) return binarySearch(nums, start, mid-1, key);
        else return binarySearch(nums, mid+1, end, key);
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
        for(int i= start; i < end; i++){
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
        IceCreamPb iceCreamPb = new IceCreamPb();
        int[] nums = {1,4,5,3,2};
        iceCreamPb.findExactExpense(nums, 4);
        int[] vals = {2,2,4,3};
        iceCreamPb.findExactExpense(vals, 4);
    }
}
