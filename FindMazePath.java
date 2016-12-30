/**
 * Created by ousmane on 12/1/16.
 */
public class FindMazePath {


    public void findPath(int[][] grid, int row, int col){
        String path = findPath(grid, 0, 0, grid.length, grid[0].length, "");
        System.out.println(path);
    }

    private String findPath(int[][] grid, int row, int col, int rowMax, int colMax, String path){
        if(row >= rowMax || col >= colMax) return "";
        if(row == rowMax-1 && col == colMax-1){
            path += "("+row+","+col+")";
            System.out.println(path);
            return path;
        }else if(row < rowMax && col < colMax){
            path +="("+row+","+col+")"+"->";
        }
        findPath(grid, row+1, col, rowMax, colMax, path);
        findPath(grid, row, col+1, rowMax, colMax, path);
        return "";
    }


    public static void main(String[] args){
        int[][] maze = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FindMazePath mp = new FindMazePath();
        mp.findPath(maze, maze.length, maze[0].length);
    }
}
