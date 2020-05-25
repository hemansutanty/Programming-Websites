import java.util.Arrays;

/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1
*/

class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        int i, j;
        for (i = number.length-1; i > 0; i--)
            if (number[i-1] < number[i])
               break;
        if (i == 0)
            return -1;
        int x = number[i-1], smallest = i;
        for (j = i+1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;
        Arrays.sort(number, i, number.length);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}