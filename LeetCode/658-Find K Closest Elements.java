import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 10^4
Absolute value of elements in the array and x will not exceed 104

*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = findCrossOver(arr, 0, arr.length-1, x);
        int r= l+1; int count =0;
        List<Integer> result = new ArrayList<>();
        while(l>=0 && r<arr.length && count<k){
            if(x-arr[l]==arr[r]-x){
                result.add(arr[l]);
                l--;
                
            }else if(x-arr[l]<arr[r]-x){
                result.add(arr[l]);l--;
            }else{
                result.add(arr[r]);r++;
            }
            count++;
        }
        while(count<k && l>=0){
            result.add(arr[l]);l--;count++;
        }
        while(count<k && r<arr.length){
            result.add(arr[r]);r++;count++;
        }
        Collections.sort(result);
        return result;
    }
    public int findCrossOver(int[] arr, int low, int high, int x){
        if (arr[high]<=x) return high;
        if(arr[low]>x) return low;
        int mid = (low+high)/2;
        if(arr[mid] <= x && arr[mid+1] > x) {
            return mid;
        }
        if(arr[mid] < x) 
            return findCrossOver(arr, mid+1, high, x); 
        return findCrossOver(arr, low, mid - 1, x); 
    }
}