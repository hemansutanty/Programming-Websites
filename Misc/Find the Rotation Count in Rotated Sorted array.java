/*
Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:

Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after 
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
*/

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class BinarySearch 
{ 
    static int countRotations(int arr[], int low, 
                                       int high) 
    { 
        if (high < low) 
            return 0; 
        if (high == low) 
            return low; 
        int mid = low + (high - low)/2;  
        if (mid < high && arr[mid+1] < arr[mid]) 
            return (mid + 1); 
        if (mid > low && arr[mid] < arr[mid - 1]) 
            return mid; 
        if (arr[high] > arr[mid]) 
            return countRotations(arr, low, mid - 1); 
  
        return countRotations(arr, mid + 1, high); 
    } 
  
    // Driver program to test above functions 
    public static void main (String[] args)  
    { 
        int arr[] = {15, 18, 2, 3, 6, 12}; 
        int n = arr.length; 
          
        System.out.println(countRotations(arr, 0, n-1)); 
    } 
} 