import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Courses {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preReq = buildOrder(numCourses, prerequisites);
        int[] result = getOrder(numCourses, preReq, prerequisites);
        return result;
    }

    private int[] getOrder(int numCourses, int[] preReq, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preReq.length; i++) {
            if (preReq[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 0; j < prerequisites.length; j++) {
                    int[] currentPreReq = prerequisites[j];
                    if (currentPreReq[1] == current) {
                        preReq[currentPreReq[0]]--;
                        if (preReq[currentPreReq[0]] == 0) {
                            queue.offer(currentPreReq[0]);
                        }
                    }
                }
                result[index++] = current;
            }
        }
        return result;
    }

    private int[] buildOrder(int numCourses, int[][] prerequisites) {
        int[] preReq = new int[numCourses];
        //[0,1] -> 1 prereq for 0
        for (int[] pre : prerequisites) {
            preReq[pre[0]]++;
        }
        return preReq;
    }

    public static void main(String[] args) {
        int[][] p = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(new Courses().findOrder(4, p)));
    }
}
