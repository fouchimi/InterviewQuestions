/**
 * Created by ousmane on 12/27/16.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n){
        if(n == 3) return true;
        int remainder = n%3;
        int q = n/3;
        if(remainder == 0 && q%3 == 0) return true;
        return false;
    }

    public static void main(String[] args){
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(9));
        System.out.println(powerOfThree.isPowerOfThree(12));
        System.out.println(powerOfThree.isPowerOfThree(81));
        System.out.println(powerOfThree.isPowerOfThree(27));
        System.out.println(powerOfThree.isPowerOfThree(21));
        System.out.println(powerOfThree.isPowerOfThree(3));
    }
}
