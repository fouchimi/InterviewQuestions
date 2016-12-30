/**
 * Created by ousmane on 12/1/16.
 */
public class AmazonMatrix {

    public int countStringAmazon(String[][] matrix, String needle){
        int count = 0;
        for(int i=0; i < matrix.length; i++){
            for(int j= 0; j<matrix[0].length; j++){
                count += countStringAmazon(matrix, needle, 0,  i, j, 0);
            }
        }
        return count;
    }

    private int countStringAmazon(String[][] matrix, String needle, int countIndex, int row, int col, int lastDir){
        if(row < 0 || col < 0 || row > matrix.length-1 || col > matrix[0].length-1) return 0;
        if(!matrix[row][col].equals("" + needle.charAt(countIndex))) return 0;
        if(countIndex == needle.length()-1) {
            return 1;
        }else {
            int count = 0;
            if(lastDir != 4)
                count += countStringAmazon(matrix, needle, countIndex+1, row, col+1, 1);
            if(lastDir != 2)
                count += countStringAmazon(matrix, needle, countIndex+1, row+1, col, 3);
            if(lastDir != 3)
                count += countStringAmazon(matrix, needle, countIndex+1, row-1, col, 2);
            if(lastDir != 1)
                count += countStringAmazon(matrix, needle, countIndex+1, row, col-1, 4);

            return count;
        }
    }

    public static void main(String[] args){
        AmazonMatrix amazonMatrix = new AmazonMatrix();
        String[][] matrix = {
                {"B", "B", "A", "B", "B", "N"},
                {"B", "B", "M", "B", "N", "O"},
                {"B", "B", "A", "B", "B", "Z"},
                {"N", "O", "Z", "B", "Z", "A"},
                {"B", "B", "B", "N", "O", "M"},
                {"N", "O", "Z", "A", "M", "A"}
        };
        int count = amazonMatrix.countStringAmazon(matrix, "AMAZON");
        System.out.println(count);
    }
}
