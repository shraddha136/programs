import java.util.Comparator;
import java.util.PriorityQueue;

class KClosest {
    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getDist() {
            return Math.sqrt(x * x + y * y);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0)
            return points;
        int[][] result = new int[K][2];
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(Comparator.comparingDouble(Point::getDist));

        for (int[] point : points) {
            minHeap.offer(new Point((double)point[0], (double)point[1]));
        }

        for (int i = 0; i < K; i++) {
            Point p = minHeap.poll();
            result[i][0] = (int)p.x;
            result[i][1] = (int)p.y;
        }
        return result;
    }
}

