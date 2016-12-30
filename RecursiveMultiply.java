/**
 * Created by ousmane on 12/1/16.
 */
public class RecursiveMultiply {

    public int multiply(int m, int n){
        if(n == 0) return 0;
        else return m + multiply(m, n-1);
    }

    public static  void main(String[] args){
        RecursiveMultiply obj = new RecursiveMultiply();
        System.out.println(obj.multiply(3, 7));
    }
}
