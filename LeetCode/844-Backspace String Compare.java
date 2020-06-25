/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int ptrS = S.length()-1, ptrT = T.length()-1;
        int skipS =0, skipT=0;
        while(ptrS>=0 || ptrT>=0){
            while(ptrS>=0){
                if(S.charAt(ptrS)=='#'){
                    skipS++;ptrS--;
                }else if(skipS>0){
                    skipS--;ptrS--;
                }else {
                    break;
                }
            }
            
            while(ptrT>=0){
                if(T.charAt(ptrT)=='#'){
                    skipT++;ptrT--;
                }else if(skipT>0){
                    skipT--;ptrT--;
                }else {
                    break;
                }
            }
            
            if(ptrS>=0 && ptrT>=0 && S.charAt(ptrS)!=T.charAt(ptrT)){
                return false;
            }
            if((ptrS>=0) != (ptrT>=0)) return false;
            
            ptrS--;ptrT--;
        }
        return true;
    }
}