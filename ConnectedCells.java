/**
 * Created by ousmane on 12/20/16.
 */
public class ConnectedCells {

    public int findMaxConnectedArea(int[][] matrix){
        int maxCount = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    int count = dfs(matrix, i, j, visited);
                    if(count > maxCount) {
                        maxCount = count;
                    }
                }
            }
        }
        return maxCount;
    }

    private int dfs(int[][] matrix, int row, int col, boolean[][] visited){
        if(row < 0 || row > matrix.length-1 || col < 0 || col > matrix[0].length-1) return 0;
        if(matrix[row][col] == 0 || visited[row][col]) return 0;
        else{
            int count = 0;
            visited[row][col] = true;
            count += matrix[row][col] + dfs(matrix, row, col+1, visited);
            count += dfs(matrix, row+1, col, visited);
            count += dfs(matrix, row, col-1, visited);
            count += dfs(matrix, row-1, col, visited);

            return count;
        }
    }

    public static void main(String[] args){
        ConnectedCells connectedCells = new ConnectedCells();
        int[][] matrix = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        System.out.println(connectedCells.findMaxConnectedArea(matrix));
    }
}
