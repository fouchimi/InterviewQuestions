/**
 * Created by ousmane on 12/6/16.
 */
public class TrapWater {

    public int maxWaterTrapped(int[] height){
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for(int i=1; i < height.length; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }

        print(left);

        right[height.length-1] = height[height.length-1];
        for(int j=height.length-2; j >=0; j--){
            right[j] = Math.max(height[j], right[j+1]);
        }

        print(right);

        int sum=0;
        for(int i=0; i < height.length; i++){
            sum += (Math.min(right[i], left[i])) - height[i];
        }

        return sum;
    }

    public void print(int[] height){
        for(int i=0; i < height.length; i++){
            System.out.print(height[i] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        TrapWater trapWater = new TrapWater();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("The maximum number of water it can hold is: " + trapWater.maxWaterTrapped(heights));
    }
}
