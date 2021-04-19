/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500
*/

/*
(a+b)%60 = 0
 => (a%60 + b%60)%60 = 0
 
WE keep a map of mods and number of times the mod has been encountered
Therefore what we do is for every element we do a mod 60 and find out if we have 60-mod value in map as key and take its value coz that many times the mod has been encountered and add it to result
Also we update the map wether we found the key or not.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int result = 0;
        
        for(int t : time){
            if(t % 60==0){
                result+=countMap.getOrDefault(0,0);
            }
            else{
                result+=countMap.getOrDefault(60-t%60,0);  
            }
            countMap.put(t%60, countMap.getOrDefault(t%60,0)+1);
        }
        return result;
    }
}
