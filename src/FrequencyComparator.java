import java.util.Comparator;

/**
 * Created by ousmane on 12/27/16.
 */
public class FrequencyComparator implements Comparator<Couple> {

    @Override
    public int compare(Couple first, Couple second) {
        if(first.freq > second.freq) return -1;
        else if(first.freq < second.freq) return 1;
        else return 0;
    }
}
