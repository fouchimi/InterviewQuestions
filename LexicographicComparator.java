import java.util.Comparator;

/**
 * Created by ousmane on 12/27/16.
 */
public class LexicographicComparator implements Comparator<Couple> {

    @Override
    public int compare(Couple first, Couple second) {
        int firstValue = (int) first.ch;
        int secondValue = (int) second.ch;
        if(firstValue > secondValue) return 1;
        else if(firstValue < secondValue) return -1;
        else return 0;
    }
}
