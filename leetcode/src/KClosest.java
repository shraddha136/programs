import java.util.Arrays;
import java.util.PriorityQueue;

class KClosest {
    class Point {
        int x;
        int y;
        double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance() {
            this.distance = Math.sqrt(x * x + y * y);
            return this.distance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K > points.length)
            return points;

        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> (Double.compare(b.getDistance(), a.getDistance())));


        for (int i = 0; i < K; i++) {
            maxHeap.offer(new Point(points[i][0], points[i][1]));
        }
        for (int i = K; i < points.length; i++) {
            maxHeap.offer(new Point(points[i][0], points[i][1]));
            if (maxHeap.size() > K)
                maxHeap.poll();
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point point = maxHeap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points =
                {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(new KClosest().kClosest(points, 2)));
    }
}