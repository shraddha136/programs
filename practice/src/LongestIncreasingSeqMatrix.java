public class LongestIncreasingSeqMatrix {

    public int longestIncrSeq(int[][] matrix){
        return maxLen(matrix,0,0,1, Integer.MIN_VALUE);
    }
    private static int count = 0;
    private int maxLen(int[][] matrix, int i, int j, int len, int pastVal) {
        count++;
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j]<= pastVal){
            return len-1;
        }
        return Math.max(maxLen(matrix,i+1,j,len+1,matrix[i][j]),maxLen(matrix,i,j+1,len+1,matrix[i][j]));
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{2,2,3,4},{3,2,3,4},{4,5,6,7}};
        System.out.println(new LongestIncreasingSeqMatrix().longestIncrSeq(matrix));
        System.out.println(count);
    }
}
