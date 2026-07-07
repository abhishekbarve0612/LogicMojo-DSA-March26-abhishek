package selfPractice.matrix;

public class NumberOfClosedIslands {
    int[] dx = { -1, 0, 1, 0};
    int[] dy = { 0, 1, 0, -1};
    boolean[][] visited;
    int rows, cols;
    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, grid);
            dfs(i, cols - 1, grid);
        }

        for (int i = 0; i < cols; i++) {
            dfs(0, i, grid);
            dfs(rows - 1, i, grid);
        }

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] == false && grid[row][col] != 1) {
                    dfs(row, col, grid);
                    islands++;
                }
            }
        }

        return islands;

    }

    public void dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) return;
        if (visited[row][col]) return;

        if (grid[row][col] == 1) return;
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];
            dfs(nx, ny, grid);
        }
    }
}

/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.



Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2


Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
 */