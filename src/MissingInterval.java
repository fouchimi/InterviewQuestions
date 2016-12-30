import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 11/15/16.
 */
public class MissingInterval {

    public static String printMissingElts(int min, int max, List<Integer> list){
        int size = list.size();
        int diff = 0, val = 0;
        String result = "";
        if(list.isEmpty()){
            return min+"-"+max;
        }else if(list.size() == 1){
            if(list.get(0) == min) return (min+1)+"-"+max;
            else if(list.get(0) == max) return (min)+"-"+(max-1);
            else if((list.get(0)-min) == 1) return min +","+(list.get(0)+1)+"-"+max;
            else if((max-list.get(0)) == 1) return min+"-"+(list.get(0)-1)+","+max;
            else return min + "-" + (list.get(0)-1) + ","+ (list.get(0)+1) + "-" + (max);
        }else {
            for(int i=0; i < size; i++){
                val = list.get(i);
                if(i == 0 &&  val != min) {
                    diff = val - min;
                    if(diff == 1) result += min+ ",";
                    else if(diff == 2) result += (min+1)+",";
                    else result += min +"-"+(val-1)+",";
                }else if(i == (size-1) && val != max ){
                    if(size == 2){
                        diff = val - list.get(i-1);
                        if(diff == 2) result += (val-1)+",";
                        else if(diff > 2) result +=(list.get(i-1)+1)+"-"+(val-1)+",";
                    }
                    diff = max - val;
                    if(diff == 1) result += max;
                    else if(diff == 2) result += (val+1)+",";
                    else result += (val+1) + "-" + max + ",";
                }else if(i <= (size -2)){
                    if((val+1) == list.get(i+1)) continue;
                    else {
                        diff = list.get(i+1) - val;
                        if(diff == 2) result += (val+1) +",";
                        else result += (val+1)+"-"+(list.get(i+1)-1)+",";
                    }
                }
            }
        }

        return result.substring(0, result.length()-1);
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(50);
        list.add(52);
        list.add(75);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        list.add(3);
        list.add(5);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        list.add(0);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        list.add(5);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        list.add(1);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
        list = new ArrayList<>();
        list.add(98);
        System.out.println(MissingInterval.printMissingElts(0, 99, list));
    }
}
