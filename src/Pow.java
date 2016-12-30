/**
 * Created by ousmane on 12/27/16.
 */
public class Pow {

    public double myPow(double x, int n) {
        double sum = 0;
        if(n == 1) return x;
        sum += x * myPow(x, n-1);
        return sum;
    }

    public static void main(String[] args){
        Pow pow = new Pow();
        System.out.println(pow.myPow(3, 4));
    }

}
