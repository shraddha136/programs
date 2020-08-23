import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'calculateDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING cityMap as parameter.
     */

    private static List<char[]> incidentArray;

    Result() {

    }

    public static int calculateDistance(String cityMap) {
        // Write your code here
        String[] cityMapArray = cityMap.split(";");
        incidentArray = new ArrayList<>();
        buildCityMap(cityMapArray);
        return calculateDistanceUsingMap();
    }

    private static void buildCityMap(String[] cityMapArray) {
        // for(int index = 0;index < cityMapArray.length;index++){
        //     char[] current = cityMapArray[index].toCharArray();
        //     for(int index2 = 0;index2<current.length;index2++){
        //         incidentArray[index][index2] = current[index2];
        //     }
        // }

        for (String s : cityMapArray) {
            char[] currentList = s.toCharArray();
            incidentArray.add(currentList);
        }


        // for(int i = 0;i<incidentArray.length;i++){
        //     for(int j = 0;j<incidentArray[0].length;j++){
        //         System.out.println(incidentArray[i][j]);
        //     }
        // }
    }

    private static int calculateDistanceUsingMap() {
        for (int i = 0; i < incidentArray.size(); i++) {
            for (int j = 0; j < incidentArray.get(0).length; j++) {
                if (incidentArray.get(i)[j] == 'O') {
                    return traverse(i, j);
                }
            }
        }
        return -1;
    }

    private static int traverse(int i, int j) {
        Queue<int[]> mapQueue = new ArrayDeque<>();
        mapQueue.offer(new int[]{i, j});
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int dist = 0;
        while (!mapQueue.isEmpty()) {
            int size = mapQueue.size();
            for (int index = 0; index < size; index++) {
                int[] curr = mapQueue.poll();
                System.out.println(curr[0] + "," + curr[1]);

                for (int[] dir : directions) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    if (valid(newX, newY)) {
                        if (incidentArray.get(newX)[newY] == 'T') {
                            return dist + 1;
                        }
                        System.out.println(newX + "," + newY + "," + incidentArray.get(newX)[newY]);
                        incidentArray.get(newX)[newY] = 'X';
                        mapQueue.offer(new int[]{newX, newY});
                    }

                }
            }
            dist++;
        }
        return -1;
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < incidentArray.size() && y < incidentArray.get(x).length && incidentArray.get(x)[y] != 'X';
    }

}

