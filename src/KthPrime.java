import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/26/16.
 */
public class KthPrime {

    public void printKthPrimesElts(int k){
        List<Integer> primeList = new ArrayList<>();
        primeList.add(1);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);
        List<Integer> resultList  =new ArrayList<>();
        resultList.add(1);
        int val = 0;
        boolean flag = false;
        for(int i=2; i < k; i++){
            for(Integer divider: primeList){
                if(i%divider == 0 && divider != 1){
                    val = i/divider;
                    flag = true;
                    break;
                }
            }
            if(flag){
                if(isPrime(val) && primeList.contains(val)){
                    resultList.add(i);
                }
                flag = false;
            }
        }
        for(Integer prime: resultList){
            System.out.print(prime + " ");
        }
        System.out.println();
    }

    private boolean isPrime(int val){
        if(val == 1) return true;
        for(int i=2; i <=val/2; i++){
            if(val%i == 0) return false;
        }
        return true;
    }

    public static  void main(String[] args){
        KthPrime kth  = new KthPrime();
        kth.printKthPrimesElts(60);
    }
}
