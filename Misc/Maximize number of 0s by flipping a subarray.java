/*
Given a binary array, find the maximum number zeros in an array with one flip of a subarray allowed. A flip operation switches all 0s to 1s and 1s to 0s.

Examples:

Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
Output : 6
We can get 6 zeros by flipping the subarray {1, 1}

Input :  arr[] = {0, 0, 0, 1, 0, 1}
Output : 5
*/
class GFG { 
    public static int findMaxZeroCount(int arr[], int n) 
    { 
        int max_diff = 0; 
        int orig_zero_count = 0;  
        for (int i=0; i<n; i++) 
        { 
            if (arr[i] == 0) 
                orig_zero_count++;  
            int count1 = 0, count0 = 0; 
            for (int j = i; j < n; j ++) 
            { 
                if(arr[j] == 1) 
                    count1++; 
                else count0++; 
                max_diff = Math.max(max_diff, count1 - count0); 
            } 
        } 
        return orig_zero_count + max_diff; 
    } 
      
    /* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = {0, 1, 0, 0, 1, 1, 0}; 
          
        System.out.println(findMaxZeroCount(arr, arr.length)); 
    } 
  }
