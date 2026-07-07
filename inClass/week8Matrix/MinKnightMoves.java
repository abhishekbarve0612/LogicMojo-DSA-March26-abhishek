package inClass.week8Matrix;

import java.util.Deque;
import java.util.LinkedList;

public class MinKnightMoves {
    record Pair(int x, int y) {}
    public int minKnightMoves(int x, int y) {
        int[] dx = { -2, -2, -1, -1, 2, 2, 1, 1};
        int[] dy = { -1, 1, 2, -2, -1, 1, -2, 2};
        Deque<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[301][301];
        x = Math.abs(x);
        y = Math.abs(y);
        q.offerLast(new Pair(0, 0));
        visited[0][0] = true;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.pollFirst();
                int currX = pair.x();
                int currY = pair.y();

                if (currX == x && currY == y) return distance;

                for (int k = 0; k < dx.length; k++) {
                    int nx = Math.abs(dx[k] + currX);
                    int ny = Math.abs(dy[k] + currY);

                    if (nx >= 301 || ny >= 301) continue;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offerLast(new Pair(nx, ny));
                }
            }
            distance++;
        }

        return -1;

    }
}

/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.



Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


Constraints:

-300 <= x, y <= 300
0 <= |x| + |y| <= 300
 */