/*
Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.

Example 1:

Input: [1, 3, 8, 4, 3], key=4
Output: 3
Example 2:

Input: [3, 8, 3, 1], key=8
Output: 1
Example 3:

Input: [1, 3, 8, 12], key=12
Output: 3
Example 4:

Input: [10, 9, 8], key=10
Output: 0
*/

/*
First, we can find the index of the maximum value of the bitonic array, similar to Bitonic Array Maximum. Let’s call the index of the maximum number maxIndex.
Now, we can break the array into two sub-arrays:
Array from index ‘0’ to maxIndex, sorted in ascending order.
Array from index maxIndex+1 to array_length-1, sorted in descending order.
We can then call Binary Search separately in these two arrays to search the ‘key’.
*/


class SearchBitonicArray {

    public static int search(int[] arr, int key) {
      int maxIndex = findMax(arr);
      int keyIndex = binarySearch(arr, key, 0, maxIndex);
      if (keyIndex != -1)
        return keyIndex;
      return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }
  
    // find index of the maximum value in a bitonic array
    public static int findMax(int[] arr) {
      int start = 0, end = arr.length - 1;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1]) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
  
      // at the end of the while loop, 'start == end'
      return start;
    }
  
    // order-agnostic binary search
    private static int binarySearch(int[] arr, int key, int start, int end) {
      while (start <= end) {
        int mid = start + (end - start) / 2;
  
        if (key == arr[mid])
          return mid;
  
        if (arr[start] < arr[end]) { // ascending order
          if (key < arr[mid]) {
            end = mid - 1;
          } else { // key > arr[mid]
            start = mid + 1;
          }
        } else { // descending order        
          if (key > arr[mid]) {
            end = mid - 1;
          } else { // key < arr[mid]
            start = mid + 1;
          }
        }
      }
      return -1; // element is not found
    }
  
    public static void main(String[] args) {
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
      System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
      System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
  }