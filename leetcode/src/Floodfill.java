import java.util.Arrays;

public class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0)
            return image;
        int oldColor = image[sr][sc];
        floodFill(image, oldColor, sr, sc, newColor);

        return image;
    }

    private void floodFill(int[][] image, int oldColor, int sr, int sc, int newColor){
        if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != oldColor|| image[sr][sc] == newColor )
            return;
        if(image[sr][sc]==oldColor)
            image[sr][sc] = newColor;

        floodFill(image, oldColor,sr - 1, sc, newColor);
        floodFill(image,oldColor, sr + 1, sc, newColor);
        floodFill(image,oldColor, sr, sc - 1, newColor);
        floodFill(image,oldColor, sr, sc + 1, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(new Floodfill().floodFill(image, 1, 1, 2)));
    }
}
