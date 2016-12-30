/**
 * Created by ousmane on 12/24/16.
 */
public class CountLuck {

    public void countLuck(char[][] M, int k){
        for(int i=0; i < M.length; i++){
            for(int j=0; j < M[0].length; j++){
                if(M[i][j] == 'M')
                    countLuck(M, i, j, k, 0, 0, 0);
            }
        }
        return;
    }

    private void countLuck(char[][]M, int row, int col, int k, int count, int prevDir, int nextDir){
        if(row < 0 || col < 0 || row > M.length-1 || col > M[0].length-1) return;
        if(M[row][col] == 'X') return ;
        else {
            if(M[row][col] == '*') {
                if(k == 0 || ((count == 1) && (prevDir == nextDir))) {
                    System.out.println("I'm impressed");
                }else{
                    System.out.println("Oops");
                }
                return;
            }
            if(prevDir != nextDir) {
                count++;
                if(count%2 == 0){
                    k--;
                }
            }
            if(nextDir != 3)
                countLuck(M, row, col+1, k, count, nextDir,  1);
            if(nextDir != 4)
                countLuck(M, row+1, col, k, count, nextDir,  2);
            if(nextDir != 1)
                countLuck(M, row, col-1, k, count, nextDir,  3);
            if(nextDir != 2)
                countLuck(M, row-1, col, k, count, nextDir,  4);
        }
    }

    public static void main(String[] args){
        CountLuck countLuck = new CountLuck();
      char[][] matrix = {{'.', 'X', '.', 'X', '.', '.', '.', '.', '.', '.', 'X'},
                         {'.', 'X', '*', '.', 'X', '.', 'X', 'X', 'X', '.', 'X'},
                         {'.', 'X', 'X', '.', 'X', '.', 'X', 'M', '.', '.', '.'},
                         {'.', '.', '.', '.', '.', '.', 'X', 'X', 'X', 'X', '.'} };
      countLuck.countLuck(matrix, 3);
      countLuck.countLuck(matrix, 4);
      char[][] m = {{'*', '.', 'M'}, {'.', 'X', '.'}};
      countLuck.countLuck(m, 1);
    }
}
