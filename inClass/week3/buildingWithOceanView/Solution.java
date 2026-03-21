import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getBuildingsWithOceanView(int[] buildings) {
        ArrayList<Integer> result = new ArrayList<>();

        int maxHeightOFBuildingFromRight = 0;

        for (int i = buildings.length - 1; i > -1; i--) {
            if (buildings[i] > maxHeightOFBuildingFromRight) {
                result.add(i);
                maxHeightOFBuildingFromRight = buildings[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{ 4, 2, 3, 1 };

        ArrayList<Integer> result = solution.getBuildingsWithOceanView(arr);

        for (int num: result) System.out.print(num + " ");
    }
}