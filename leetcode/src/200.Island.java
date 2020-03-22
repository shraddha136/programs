import javax.crypto.spec.PSource;

class Island {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    visit(i, j, grid);
                }
            }
        }
        return islands;
    }

    private char[][] visit(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]=='0')
            return grid;

        grid[i][j] = '0';
        visit(i - 1, j, grid);
        visit(i + 1, j, grid);
        visit(i, j - 1, grid);
        visit(i, j + 1, grid);
        return grid;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Island().numIslands(grid));

        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(new Island().numIslands(grid2));
    }

}
