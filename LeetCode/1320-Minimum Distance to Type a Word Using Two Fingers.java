import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*


https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

You have a keyboard layout as shown above in the XY plane, where each English uppercase letter is located at some coordinate, for example, the letter A is located at coordinate (0,0), the letter B is located at coordinate (0,1), the letter P is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).

Given the string word, return the minimum total distance to type such string using only two fingers. The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|. 

Note that the initial positions of your two fingers are considered free so don't count towards your total distance, also your two fingers do not have to start at the first letter or the first two letters.

 

Example 1:

Input: word = "CAKE"
Output: 3
Explanation: 
Using two fingers, one optimal way to type "CAKE" is: 
Finger 1 on letter 'C' -> cost = 0 
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2 
Finger 2 on letter 'K' -> cost = 0 
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1 
Total distance = 3
Example 2:

Input: word = "HAPPY"
Output: 6
Explanation: 
Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -> cost = 0
Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6
Example 3:

Input: word = "NEW"
Output: 3
Example 4:

Input: word = "YEAR"
Output: 7
 

Constraints:

2 <= word.length <= 300
Each word[i] is an English uppercase letter.
*/


class Solution {
    
    private Map<Character, int[]> keyMap = new HashMap<>();
    private Map<String, Integer> cache = new HashMap<>();
    
    public int calculateDistanceBetweenFingers(int[] finger1, int[] finger2){
        if(finger1==null || finger2==null){
            return 0;
        }
        return (Math.abs(finger1[0]-finger2[0])+Math.abs(finger1[1]-finger2[1]));
    }
    public int minimumDistance(String word) {
        char ch = 'A';
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                keyMap.put(ch, new int[]{i,j});
                if(ch=='Z')break;
                ch++;
            }
        }
        return minimumDistance(null, null, 0, word);
    }
    public int minimumDistance(int[] finger1, int[] finger2, int index, String word){
        if(index>=word.length()) return 0;
        String key = Arrays.toString(finger1)+":"+Arrays.toString(finger2)+":"+index;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int useFinger1 = calculateDistanceBetweenFingers(finger1, keyMap.get(word.charAt(index)))+
            minimumDistance(keyMap.get(word.charAt(index)), finger2, index+1, word);
        int useFinger2 = calculateDistanceBetweenFingers(finger2, keyMap.get(word.charAt(index)))+
            minimumDistance(finger1, keyMap.get(word.charAt(index)), index+1, word);
        int output = Math.min(useFinger1, useFinger2);
        cache.put(key, output);
        return output;
    }
}