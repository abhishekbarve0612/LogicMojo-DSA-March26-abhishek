// [[0,30], [5, 10], [15, 20]]
// 2

import java.util.*;

class Solution {
    public int getMinConferenceRoomsRequired(int[][] intervals) {
        Map<Integer, Integer> hash = new TreeMap<>();

        for (int[] interval: intervals) {
            hash.put(interval[0], hash.getOrDefault(interval[0], 0) + 1);
            hash.put(interval[1], hash.getOrDefault(interval[1], 0) - 1);
        }

        int count = 0;
        int maxCount = 0;

        for(Map.Entry<Integer, Integer> entry: hash.entrySet()) {
            count += entry.getValue();
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][] { {0, 30}, {5, 10}, {15, 20} };

        int result = solution.getMinConferenceRoomsRequired(arr);

        System.out.println(result);
    }
}