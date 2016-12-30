import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/4/16.
 */
public class QueenProblem {

    private void printQueens(int[][] matrix, int row, int col, List<Point> list, int queens, int lastDir, int count){
        if((row < 0) || (row > matrix.length-1) || (col < 0) || (col > matrix[0].length-1)) return;
        if(isValidPosition(row, col, list)){
            list.add(new Point(row, col));
            queens--;
        }
        if(queens == 0){
            for(Point point : list){
                System.out.print(point + " ");
            }
            System.out.println();
            return;
        }
        if(matrix[row][col] != -1) {
            matrix[row][col] = -1;
            count++;
        }
        if(count == matrix.length*matrix[0].length) return;
        else {
            if(lastDir != 3 && col+1 < matrix[0].length && matrix[row][col+1] != -1){
                printQueens(matrix, row, col+1, list, queens, 1, count);
            }
            if(lastDir != 4 && row+1 < matrix.length && matrix[row+1][col] != -1){
                printQueens(matrix, row+1, col, list, queens, 2, count);
            }
            if(lastDir != 1 && col-1>=0 && matrix[row][col-1] != -1)
                printQueens(matrix, row, col-1, list, queens, 3, count);
            if(lastDir != 2 && row-1 >= 0 && matrix[row-1][col] != -1)
                printQueens(matrix, row-1, col, list, queens, 4, count);
        }
    }

    public void printQueens(int[][] matrix, int queens){
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j< matrix[0].length; j++){
                List<Point> list = new ArrayList<>();
                printQueens(matrix, i, j, list, queens, 0, 0);
                reinitialize(matrix);
            }
        }
    }

    private void reinitialize(int[][] matrix){
        for(int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=0;
            }
        }
    }

    private boolean isValidPosition(int row, int col, List<Point> list){
        if(list.isEmpty()) return true;
        else {
            for(Point point : list){
                if(point.getX() == row || point.getY() == col){
                    return false;
                }
                int diffX = row - point.getX();
                int diffY = col - point.getY();
                if(diffX < 0) diffX = diffX*(-1);
                if(diffY < 0) diffY = diffY*(-1);
                if(diffX == diffY) return false;
            }
            return true;
        }
    }

    public static void main(String[] args){
        QueenProblem qp = new QueenProblem();
        int[][] matrix = new int[4][4];
        int queens = 4;
        qp.printQueens(matrix, queens);
    }
}
