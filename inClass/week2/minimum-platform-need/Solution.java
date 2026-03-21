// Given a schedule containing the arrival and departure time of trains in a station, find the
// minimum number of platforms needed to avoid delay in any train’s arrival.
// Example: Trains arrival = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 }
// Trains departure = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 }
// The minimum platforms needed is 2

import java.util.Arrays;

class Solution {
    public int getMinimumPlatformCount(float[] arrivals, float[] departures) {
        int platforms = 0;
        int maxPlatforms = platforms;

        int arrival = 0, departure = 0;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        while (arrival < arrivals.length) {
            if (arrivals[arrival] < departures[departure]) {
                platforms++;
                arrival++;
            } else {
                departure++;
                maxPlatforms = Math.max(--platforms, maxPlatforms);
            }
        }


        return Math.max(1, maxPlatforms);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        float[] arrivals = { 2.00f, 2.10f, 3.00f, 3.20f, 3.50f, 5.00f };
        float[] departures = { 2.30f, 3.40f, 3.20f, 4.30f, 4.00f, 5.20f };

        int result = solution.getMinimumPlatformCount(arrivals, departures);
        System.out.println(result); // Output: 2

        float[] arrivals2 = { 1.00f, 1.30f, 1.50f, 2.00f };
        float[] departures2 = { 1.20f, 1.40f, 2.10f, 2.30f };
        int result2 = solution.getMinimumPlatformCount(arrivals2, departures2);
        System.out.println(result2); // Output: 3
     }
}