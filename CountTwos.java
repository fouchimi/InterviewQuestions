/**
 * Created by ousmane on 12/26/16.
 */
public class CountTwos {

    public int countTwos(int N){
        int count =1;
        int sum = 2;
        int prev = 0;
        System.out.print(2+", ");
        boolean isTwenties = false;
        while(sum < N){
            if(isTwenties == false){
                sum += 10;
            }else sum +=1;
            if(sum%10 == 2 && sum/10 == 2) {
                if(isTwenties == false){
                    sum -=2;
                    isTwenties=true;
                }
            }
            if(sum%10 == 2){
                prev = sum;
                System.out.print(sum + ", ");
                count++;
            }
            if(sum/10 == 2){
                if(sum != prev)
                    System.out.print(sum + ", ");
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        CountTwos countTwos = new CountTwos();
        System.out.println("The total number of 2's are: "+ countTwos.countTwos(42));
    }
}
