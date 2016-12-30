/**
 * Created by ousmane on 12/29/16.
 */
public class CountingBits {

    public int[] countBits(int num){
        int[] nums = new int[num + 1];
        for(int i=0; i <=num; i++){
            int N = i;
            int count = 0;
            while(N > 0){
                int val = (N & 1);
                if(val%2 !=0) count++;
                N /=2;
            }
            nums[i] = count;
        }
        return nums;
    }
    
    public static void main(String[] args){
        CountingBits counts = new CountingBits();
        int[] results= counts.countBits(5);
        for(int i=0; i < results.length; i++){
            System.out.print(results[i] + " ");
        }
    }
}
