public class SameLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates==null || coordinates.length==0)
            return false;

        double slope = (double)(coordinates[1][1]-coordinates[0][1])/(double)(coordinates[1][0]-coordinates[0][0]);
        for(int i = 2;i < coordinates.length;i++){
            double currSlope =  (double)(coordinates[i][1]-coordinates[i-1][1])/(double)(coordinates[i][0]-coordinates[i-1][0]);
            if(currSlope != slope)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SameLine().checkStraightLine(new int[][]{{1,1},{-6,-4},{-6,2},{2,0},{-1,-2},{0,-4}}));
        System.out.println(new SameLine().checkStraightLine(new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}}));
    }
}
