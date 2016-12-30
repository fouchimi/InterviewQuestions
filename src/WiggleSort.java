/**
 * Created by ousmane on 12/27/16.
 */
public class WiggleSort {

    public void wiggleSort(int[] nums){
        int mid = nums.length/2;
        for(int i=0; i <mid-1; i++){
            swim(nums, i);
        }

        for(int i=nums.length-1; i >=mid; i--){
            if(nums[i] < nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }

        for(int i=1, j=mid; i !=j; i=i+2, j++){
            if(nums[i] < nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        for(int i=0; i < nums.length; i++){
            System.out.print(nums[i] +" ");
        }
        System.out.println();
    }

    private void swim(int[] nums, int index){
        int l = 2*index+1, r = 2*index+2, min = index;
        if(l < nums.length && nums[l] < nums[index]) min = l;
        if(r < nums.length && nums[r] < nums[min]) min = r;
        if(index != min){
            int temp = nums[index];
            nums[index] = nums[min];
            nums[min] = temp;
            swim(nums, min);
        }
    }

    public static void main(String[] args){
        WiggleSort wiggleSort = new WiggleSort();
        int[] nums = {1,5,1,1,6,4};
        wiggleSort.wiggleSort(nums);
        int[] vals = {1, 3, 2, 2, 3, 1};
        wiggleSort.wiggleSort(vals);
    }
}
