/**
 * Created by ousmane on 11/25/16.
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] m){

        for(int i=0; i<m.length; i++){
            for(int j=i; j<m[0].length; j++){
                int val = m[i][j];
                if(i==j) m[i][j] = val;
                else  {
                    m[i][j] = m[j][i];
                    m[j][i] = val;
                }
            }
        }

        return m;
    }

    public static void main(String[] args){
        int[][] m = {{1,2,3}, {4, 8, 2}, {1, 5, 3}};
        TransposeMatrix obj = new TransposeMatrix();
        m = obj.transpose(m);
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                System.out.print(m[i][j] + ",");
            }
            System.out.println();
        }
    }
}
