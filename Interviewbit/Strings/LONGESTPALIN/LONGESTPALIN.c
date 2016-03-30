/*

Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"

*/


//Solution

/**
 * @input A : String termination by '\0'
 * 
 * @Output string. Make sure the string ends with null character
 */
char* longestPalindrome(char* A) {
    
    int maxLength = 1,low,high,start = 0,len = strlen(A),i;
    
    for(i=1;i<len;i++){
        
        
        low = i-1;
        high = i;
        while(low>=0 && high<len && A[low]==A[high]){
            if(high-low+1>maxLength){
                start = low;
                maxLength = high - low + 1;
            }
            low--;
            high++;
        }
        
        low = i-1;
        high = i+1;
        while(low>=0 && high<len && A[low]==A[high]){
            if(high-low+1>maxLength){
                start = low;
                maxLength = high - low + 1;
            }
            low--;
            high++;
        }
    }
    int k=0;
    char * result = (char*)malloc(maxLength*sizeof(char));
    for(i=start;i<start+maxLength;i++){
        result[k++]=A[i];
    }
    return result;
    
}
