//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Queue;
//
//public class FirePerson {
//
//    public static void main(String[] args) {
//        int[][] a = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
//                {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//
//        //0 - empty place
//        //1 person
//        //2 fire
//
//        System.out.println(isSafe(a));
//    }
//
//    private static int isSafe(int[][] a) {
//        Queue<int[]> personPosition = new ArrayDeque<>();
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                if (a[i][j] == 1) {
//                    personPosition.offer(new int[]{i, j});
//                    break;
//                }
//            }
//        }
//        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int distance = 0;
//        while (!personPosition.isEmpty()) {
//            int size = personPosition.size();
//            for (int i = 0; i < size; i++) {
//                int[] currentPosition = personPosition.poll();
//                for (int[] dir : direction) {
//                    int newXPosition = currentPosition[0] + dir[0];
//                    int newYPosition = currentPosition[1] + dir[1];
//                    if (isValid(newXPosition, newYPosition, a)) {
//                        if (newXPosition == 0 || newXPosition == a.length - 1 || newYPosition == 0 || newYPosition == a[0].length - 1) {
//                            return distance+1;
//                        }
//                        personPosition.offer(new int[]{newXPosition, newYPosition});
//                    }
//                }
//            }
//            distance++;
//        }
//        return -1;
//    }
//
//    private static boolean isValid(int newXPosition, int newYPosition, int[][] a) {
//        return newXPosition >= 0 && newXPosition < a.length && newYPosition >= 0 && newYPosition < a[0].length && a[newXPosition][newYPosition] != 2;
//    }
//}
