import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/1/16.
 */
public class SpiralMatrix {

    public void printSpiralMatrix(int[][] matrix){
        List<Integer> visited = new ArrayList<>();
        printSpiralMatrix(matrix, 0, 0, visited, 0);
    }


    private void printSpiralMatrix(int[][] matrix, int row, int col, List<Integer> visited, int lastDir){
        if(row < 0 || row > matrix.length-1 || col < 0 || col > matrix[0].length-1) return;
        if(!visited.contains(matrix[row][col])) {
            System.out.print(matrix[row][col] + " ");
            visited.add(matrix[row][col]);
        }
        if(visited.size() == matrix.length*matrix[0].length){
            return;
        }
        if(lastDir != 3)
            printSpiralMatrix(matrix, row, col+1, visited, 1);
        if(lastDir != 4)
            printSpiralMatrix(matrix, row+1, col, visited, 2);
        if(lastDir != 1)
            printSpiralMatrix(matrix, row, col-1, visited, 3);
        if(lastDir != 2)
            printSpiralMatrix(matrix, row-1, col, visited, 4);
    }

    public static void main(String[] args){
        SpiralMatrix spm = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spm.printSpiralMatrix(matrix);
    }

}
