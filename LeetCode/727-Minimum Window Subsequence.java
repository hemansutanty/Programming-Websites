/*
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
*/


class Solution {
    public String minWindow(String S, String T) {
        int start = -1, length = Integer.MAX_VALUE, sIndex = 0 , tIndex = 0, sLen = S.length(), tLength= T.length();
        while(sIndex<sLen){
            if(S.charAt(sIndex)==T.charAt(tIndex)){
                if(++tIndex==tLength){
                    int end = sIndex+1;
                    --tIndex;
                    while(tIndex>=0){
                        while(S.charAt(sIndex--)!=T.charAt(tIndex));
                        --tIndex;
                    }
                    ++sIndex;++tIndex;
                    if(end-sIndex<length){
                        length = end-sIndex;
                        start = sIndex;
                    }
                }
                
            }
            sIndex++;
        }
        return start==-1?"":S.substring(start, start+length);
    }
}