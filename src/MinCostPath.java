/**
 * Created by ousmane on 11/22/16.
 */
public class MinCostPath {


    public int minCost(int[][] matrix, int row, int col){
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        else if(row == 0 && col == 0) return matrix[row][col];
        else return matrix[row][col] + min(minCost(matrix, row-1, col),
                    minCost(matrix, row-1, col-1),
                    minCost(matrix, row, col-1));
    }


    public int min(int x, int y, int z){
        if(x < y){
            return (x < z) ? x : z;
        }else {
            return (y < z) ? y : z;
        }
    }

    public static void main(String[] args){
        MinCostPath obj = new MinCostPath();
        int[][] matrix = {{1,2,3}, {4, 8, 2}, {1, 5, 3}};
        System.out.println("The minimum cost is: " + obj.minCost(matrix, 2, 2));
    }
}
