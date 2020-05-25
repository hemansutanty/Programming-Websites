/*abstractFind the longest sub string length which is in Alphabetical order.
ex: input “cfaxy” and output should be 3(axy).
*/


class GFG { 
  
    // Function to return the ending index for the 
    // largest valid sub-string starting from index i 
    static int getEndingIndex(String str, int n, int i) 
    { 
        i++; 
        while (i < n) { 
            char curr = str.charAt(i); 
            char prev = str.charAt(i - 1); 
  
            // If the current character appears after 
            // the previous character  according to  
            // the given circular alphabetical order 
            if  (curr - prev >= 0) 
                i++; 
            else
                break; 
        } 
  
        return i - 1; 
    } 
  
    // Function to return the length of the longest 
    // sub-string of consecutive characters from str 
    static int largestSubStr(String str, int n) 
    { 
        int len = 0; 
  
        int i = 0; 
        while (i < n) { 
  
            // Valid sub-string exists from index 
            // i to end 
            int end = getEndingIndex(str, n, i); 
  
            // Update the length 
            len = Math.max(end - i + 1, len); 
            i = end + 1; 
        } 
  
        return len; 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String str = "abcabcdefabc"; 
        int n = str.length(); 
  
        System.out.print(largestSubStr(str, n)); 
    } 
} 