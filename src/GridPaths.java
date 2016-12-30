/**
 * Created by ousmane on 11/21/16.
 */
public class GridPaths {

    private int[][] matrix;
    private int rowCount;
    private int colCount;

    GridPaths(int[][] m){
        this.matrix = m;
        this.rowCount = matrix.length;
        this.colCount = matrix[0].length;
    }

    public  void printAllPaths(int currentRow, int currentCol, String path){
        if(currentRow == rowCount-1){
            for(int i=currentCol; i < colCount; i++){
                path += "-" + matrix[currentRow][i];
            }
            System.out.println(path.substring(1, path.length()));
            return;
        }

        if(currentCol == colCount-1){
            for(int i= currentRow; i < rowCount; i++){
                path += "-" + matrix[i][currentCol];
            }
            System.out.println(path.substring(1, path.length()));
            return;
        }

        path = path + "-" + matrix[currentRow][currentCol];
        printAllPaths(currentRow+1, currentCol, path);
        printAllPaths(currentRow, currentCol+1, path);
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        GridPaths grid = new GridPaths(matrix);
        grid.printAllPaths(0, 0, "");
    }

}
