package inClass.week8Matrix;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {
    record Pair(int x, int y) {}
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        Deque<Pair> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int distance = 1;
        if (grid[0][0] == 1) return -1;
        q.offerLast(new Pair(0, 0));
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.pollFirst();
                int cx = pair.x();
                int cy = pair.y();
                if (cx == rows - 1 && cy == cols - 1) return distance;
                for (int k = 0; k < dx.length; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];

                    if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;
                    if (grid[nx][ny] == 1) continue;
                    grid[nx][ny] = 1;
                    q.offerLast(new Pair(nx, ny));
                }
            }
            distance++;
        }

        return -1;
    }
}

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.



Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 */