/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/



/*

Evolution from Recusrive to DP :
recursive solution :


public int numDecodings(String s) {
        return s.length()==0?0:numDecodings(0,s);      
    }
    private int numDecodings(int p, String s) {
        int n=s.length();
        if(p==n) return 1;
        if(s.charAt(p)=='0') return 0;
        int res=numDecodings(p+1,s);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7')) 
			res+=numDecodings(p+2,s);
        return res;
    }

*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;        
        Integer[] mem = new Integer[n];
        return numDecodings(0,s,mem);
    }
    public int numDecodings(int p, String s, Integer[] mem){
        int n = s.length();
        if(p==n)return 1;
        if(s.charAt(p)=='0') return 0;
        if(mem[p]!=null) return mem[p];
        int result = numDecodings(p+1, s, mem);
        if(p<n-1 && (s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7')){
            result+=numDecodings(p+2, s, mem);
        }
        return mem[p]=result;
    }
}
