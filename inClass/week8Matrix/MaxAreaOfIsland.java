package inClass.week8Matrix;

public class MaxAreaOfIsland {
    int rows, cols;
    boolean[][] visited;
    int[] dx = { -1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int maxLen = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxLen = Math.max(dfs(r, c, grid), maxLen);
            }
        }
        return maxLen;
    }

    public int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) return 0;
        if (visited[row][col]) return 0;
        if (grid[row][col] == 0) return 0;
        visited[row][col] = true;
        return 1 + (
                dfs(row + dx[0],col + dy[0], grid)
                        + dfs(row + dx[1], col + dy[1], grid)
                        + dfs(row + dx[2], col + dy[2], grid)
                        + dfs(row + dx[3], col + dy[3], grid)
        );
    }
}

/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 */