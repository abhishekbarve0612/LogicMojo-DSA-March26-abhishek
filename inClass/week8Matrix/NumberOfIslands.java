package inClass.week8Matrix;

public class NumberOfIslands {
    int rows, cols;
    int[] dx = { -1, 0, 1, 0};
    int[] dy = { 0, 1, 0, -1};
    boolean[][] visited;
    int count;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visited[r][c]) continue;
                if (grid[r][c] == '0') continue;
                dfs(r, c, grid);
                count++;
            }
        }
        return count;
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) return;
        if (visited[row][col]) return;
        if (grid[row][col] == '0') return;
        visited[row][col] = true;
        for (int k = 0; k < dx.length; k++) {
            dfs(row + dx[k], col + dy[k], grid);
        }
    }
}

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */