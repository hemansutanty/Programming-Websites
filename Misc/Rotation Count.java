/*
Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.

You can assume that the array does not have any duplicates.

Example 1:

Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.
    1   
    3   
    8   
    10   
    15   
 Original array:  
 Array after 2 rotations:  
    10   
    15   
    1   
    3   
    8   
Example 2:

Input: [4, 5, 7, 9, 10, -1, 2]
Output: 5
Explanation: The array has been rotated 5 times.
 Original array:  
    -1   
    2   
    4   
    5   
    7   
    9   
    10   
    4   
    5   
    7   
    9   
    10   
    -1   
    2   
 Array after 5 rotations:  
Example 3:

Input: [1, 3, 8, 10]
Output: 0
Explanation: The array has not been rotated.
*/

/*
In this problem, actually, we are asked to find the index of the minimum element. The number of times the minimum element is moved to the right will be equal to the number of rotations. An interesting fact about the minimum element is that it is the only element in the given array which is smaller than its previous element. Since the array is sorted in ascending order, all other elements are bigger than their previous element.

After calculating the middle, we can compare the number at index middle with its previous and next number. This will give us two options:

If arr[middle] > arr[middle + 1], then the element at middle + 1 is the smallest.
If arr[middle - 1] > arr[middle], then the element at middle is the smallest.
To adjust the ranges we can follow the same approach as discussed in Search in Rotated Array. Comparing the numbers at indices start and middle will give us two options:

If arr[start] < arr[middle], the numbers from start to middle are sorted.
Else, the numbers from middle + 1 to end are sorted.
*/

class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
      int start = 0, end = arr.length - 1;
      while (start < end) {
        int mid = start + (end - start) / 2;
  
        if (mid < end && arr[mid] > arr[mid + 1]) // if mid is greater than the next element
          return mid + 1;
        if (mid > start && arr[mid - 1] > arr[mid]) // if mid is smaller than the previous element
          return mid;
  
        if (arr[start] < arr[mid]) { // left side is sorted, so the pivot is on right side
          start = mid + 1;
        } else { // right side is sorted, so the pivot is on the left side     
          end = mid - 1;
        }
      }
  
      return 0; // the array has not been rotated
    }
  
    public static void main(String[] args) {
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
  }

  
  