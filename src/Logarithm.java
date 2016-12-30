/**
 * Created by ousmane on 11/25/16.
 */
public class Logarithm {

    public int lg(int N){
        if(N == 1 || N == 0) return 0;
        int val = 1;
        int factor = 0;
        while(val < N){
            val *= 2;
            factor++;
        }

        if(val % N == 0) return factor;
        else return (factor - 1);
    }

    public static void main(String[] args){
        Logarithm obj = new Logarithm();
        System.out.println(obj.lg(8));
        System.out.println(obj.lg(4));
        System.out.println(obj.lg(5));
        System.out.println(obj.lg(1));
        System.out.println(obj.lg(0));
        System.out.println(obj.lg(16));
        System.out.println(obj.lg(9));
        System.out.println(obj.lg(17));
    }
}
