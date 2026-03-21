// 1. Given a sorted array A (sorted in ascending order), having N integers, find if there exists any
// pair of elements (A[i], A[j]) such that their sum is equal to X.
// For Example: A[] = {10, 20, 35, 50, 75, 80} and the value of X = 110

class Solution {
    public boolean hasPairWithSum(int[] A, int X) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int sum = A[left] + A[right];
            if (sum == X) {
                return true;
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {10, 20, 35, 50, 75, 80};
        int X = 110;
        boolean result = solution.hasPairWithSum(A, X);
        System.out.println(result); // Output: true
    }
}