// // Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with
// // elements of array Y[] by maintaining the sorted order, i.e., fill X[] with the first m smallest
// // elements and fill Y[] with remaining elements.

// Input:
// X[] = { 1, 4, 7, 8, 10 }
// Y[] = { 2, 3, 9 }
// Output:
// X[] = { 1, 2, 3, 4, 7 }
// Y[] = { 8, 9, 10 }

class Solution {
    public void mergeArray(int[] arr1, int[] arr2) {
        int first = 0, second = 0;

        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] < arr2[second]) first++;
            else {
                int temp = arr1[first];
                arr1[first] = arr2[second];
                arr2[second] = temp;
                first++;

                // put arr2 second it in correct position

                temp = arr2[second];

                while (second < arr2.length - 1 && temp > arr2[second + 1]) {
                    arr2[second] = arr2[second + 1];
                    second++;
                }
                arr2[second] = temp;
                second = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = { 1, 4, 7, 8, 10 };
        int[] arr2 = { 2, 3, 9 };

        solution.mergeArray(arr1, arr2);

        for (int num : arr1) { // Output: 1 2 3 4 7
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : arr2) { // Output: 8 9 10
            System.out.print(num + " ");
        }
     }
}