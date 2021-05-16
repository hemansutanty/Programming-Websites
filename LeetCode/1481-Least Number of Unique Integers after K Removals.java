import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length

*/

/*
Count number then count occurrence:

Count the occurrences of each number using HashMap;
Using Array to count each occurrence, since max occurrence <= arr.length;
From small to big, for each unvisited least frequent element, deduct from k the multiplication with the number of elements of same occurrence, check if reaching 0, then deduct the correponding unique count remaining.
*/
/*
Analysis:
Time: O(n), space: O(n).
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: arr)count.put(num, count.getOrDefault(num,0)+1);
        int[] occurenceArray = new int[arr.length+1];
        for(int value:count.values()){
            occurenceArray[value] = occurenceArray[value]+1;
        }
        int remaining = count.size(), occur = 1;
        while(k>0){
            if(k-occur*occurenceArray[occur]>=0){
                k = k - occur*occurenceArray[occur];
                remaining = remaining - occurenceArray[occur];
                occur++;
            }else{
                return remaining - k/occur;
            }
        }
        return remaining;
        
    }
}