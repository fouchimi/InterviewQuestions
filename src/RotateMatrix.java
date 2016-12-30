/**
 * Created by ousmane on 12/14/16.
 */
public class RotateMatrix {

    public boolean rotateMatrix(int[][] matrix) {
        if(matrix.length != matrix[0].length || matrix.length == 0) return false;

        for(int layer = 0; layer <matrix.length/2; layer++){
            int first = layer;
            int last = matrix.length - layer - 1;
            for(int i=first; i <last; i++){
                int offset = i-first;
                int temp = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
        printMatrix(matrix);
        return true;
    }

    public void printMatrix(int[][] matrix) {

        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public static void main(String[] args){
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        rm.rotateMatrix(matrix);
    }
}
