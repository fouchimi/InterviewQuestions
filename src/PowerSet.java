import java.util.ArrayList;

/**
 * Created by ousmane on 12/1/16.
 */
public class PowerSet {

    ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(set.size() == index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<>());
        }else{
            allSubsets = getSubSets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for(ArrayList<Integer> subset: allSubsets){
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subset);
                newSubSet.add(item);
                moreSubsets.add(newSubSet);
            }

            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static void main(String[] args){
        PowerSet set = new PowerSet();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> allSubsets = set.getSubSets(list, 0);
        for(ArrayList<Integer> eachSubSet: allSubsets){
            System.out.print(eachSubSet + ", ");
        }
    }
}
