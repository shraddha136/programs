import java.util.*;

public class QueueReconstrution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2)->p1[0]==p2[0]?p1[1]-p2[1]:p2[0]-p1[0]);

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] a = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(Arrays.deepToString(new QueueReconstrution().reconstructQueue(a)));
    }
}
