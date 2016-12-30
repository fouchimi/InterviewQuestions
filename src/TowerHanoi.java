/**
 * Created by ousmane on 12/1/16.
 */
public class TowerHanoi {

    public void printMoves(int n, String from, String to, String spare){
        if(n == 1) {
            System.out.println("Move from " + from + " to " + to);
            return;
        }
        printMoves(n-1, from, spare, to);
        printMoves(1, from, to, spare);
        printMoves(n-1, spare, to, from);
    }

    public static void main(String[] args){
        TowerHanoi th = new TowerHanoi();
        th.printMoves(4, "f", "t", "s");
    }
}
