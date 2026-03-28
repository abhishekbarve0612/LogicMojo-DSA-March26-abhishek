// Given a nearly sorted array such that each of the n elements may be misplaced by no more
// than one position from the correct sorted order, search a given element in it efficiently.
// Report if the element is not present in the array. An element at index i in a correctly sorted
// order can be misplaced by the ± 1 position, i.e., it can be present at index i-1 or i or i+1 in the
// input array.
//         0  1  2  3  4  5  6  7  8    
// nums = [2, 1, 3, 5, 4, 7, 6, 8, 9]
//         1  2  3  4 5  6  7  8  9
//         
// target = 5
// Output: Element 5 found at index 3

class Solution {
    public int findMisplacedElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (mid - 1 >= left && nums[mid - 1] == target)
                return mid - 1;

            if (mid + 1 <= right && nums[mid + 1] == target)
                return mid + 1;

            if (target > nums[mid])
                left = mid + 2;
            else
                right = mid - 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 3, 5, 4, 7, 6, 8, 9 };
        int target = 5;

        Solution sol = new Solution();

        int result = sol.findMisplacedElement(arr, target);

        System.out.println(result);
    }
}