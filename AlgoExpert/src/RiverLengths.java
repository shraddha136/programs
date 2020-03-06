import java.util.*;

class RiverLengths {
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int riverCount = 0;
        List<Integer> riverLengths = new ArrayList<Integer>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    riverCount = traverse(i,j,matrix,riverCount);
                    riverLengths.add(riverCount);
                }
            }
        }
        return riverLengths;
    }

    private static int traverse(int i, int j, int[][] matrix, int riverCount){
        if(matrix[i][j]==1){
            riverCount++;
            matrix[i][j]=0;
        }else
            return 0;

        if(i>0)
            traverse(i-1,j,matrix,riverCount);
        if(i<matrix.length-1)
            traverse(i+1,j,matrix,riverCount);
        if(j>0)
            traverse(i,j-1,matrix,riverCount);
        if(j<matrix[0].length-1)
            traverse(i,j+1,matrix,riverCount);

        return riverCount;
    }

    public static void main(String[] args) {
        System.out.println(riverSizes(new int[][]{{1,1,1,0,1,1,0,0,0,1,0}}));
    }
}
