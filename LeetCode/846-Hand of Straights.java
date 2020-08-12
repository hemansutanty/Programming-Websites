import java.util.TreeMap;

/*
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
 

Constraints:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W!=0)return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            if(treeMap.containsKey(hand[i])){
                treeMap.put(hand[i], treeMap.get(hand[i])+1);
            }else{
                treeMap.put(hand[i], 1);
            }
        }
        
        while(treeMap.size()>0){
            int min_val = treeMap.firstKey();
            for(int i = min_val;i<min_val+W;i++){
                if(!treeMap.containsKey(i))return false;
                int count = treeMap.get(i);
                if(count==1){
                    treeMap.remove(i);
                    
                }else {
                    treeMap.put(i, treeMap.get(i)-1);
                }
            }
        }
        return true;
    }
}