/**
 * Created by ousmane on 12/27/16.
 */
public class BulbSwitch {

    public int bulbSwitch(int n){
        int[] bulbs = new int[n];
        for(int i=0; i < bulbs.length; i++){
            bulbs[i] = 0;
        }
        bulbs = bulbSwitch(bulbs, 1);
        int count = 0;
        for(int i=0; i < bulbs.length; i++){
            if(bulbs[i] == 1) count++;
        }

        return count;
    }

    private int[] bulbSwitch(int[] bulbs, int index){
        if(index == bulbs.length+1) return bulbs;
        else {
            if(index==1){
                for(int i=0; i < bulbs.length; i++){
                    bulbs[i] = 1;
                }
            }else if(index>1){
                int incr = index-1;
                for(int i=incr; i < bulbs.length; ){
                    if(bulbs[i] == 0){
                        bulbs[i] =1;
                    }else {
                        bulbs[i] = 0;
                    }
                    i = i+incr+1;
                }
            }
            return bulbSwitch(bulbs, index+1);
        }
    }

    public static void main(String[] args){
        BulbSwitch bulbSwitch = new BulbSwitch();
        System.out.println("There are: " + bulbSwitch.bulbSwitch(3) + " turn on");
    }
}
