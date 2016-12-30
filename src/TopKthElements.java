import java.util.*;

/**
 * Created by ousmane on 12/27/16.
 */
public class TopKthElements {

    public List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int key = nums[i];
            if(!map.containsKey(key)){
                map.put(key, 1);
            }else {
                int freq = map.get(key);
                map.put(key, freq+1);
            }
        }

        Iterator itr = map.entrySet().iterator();
        List<Integer> resultList = new ArrayList<>();
        while(itr.hasNext()){
            Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) itr.next();
            if(pair.getValue() >= k){
                resultList.add(pair.getKey());
            }
        }
        return resultList;
    }

    public static void main(String[] args){
        TopKthElements tp = new TopKthElements();
        int[] A = {1,1,1,2,2,3};
        int k=2;
        for(Integer val : tp.topKFrequent(A, k)){
            System.out.print(val + " ");
        }
    }
}
