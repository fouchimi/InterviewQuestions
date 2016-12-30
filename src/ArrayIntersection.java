/**
 * Created by ousmane on 12/29/16.
 */
public class ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2){
        int[] result = new int[1];

        for(int i=0; i < nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]) result[0] = nums1[i];
            }
        }

        return result;
    }

    public static void main(String[] args){
        ArrayIntersection intersection = new ArrayIntersection();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println("The intersection: " + intersection.intersection(nums1, nums2)[0]);
    }
}
