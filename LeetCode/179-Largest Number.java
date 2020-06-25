import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

class Solution {
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        int index=0;
        for(int num: nums){
            stringNums[index++]= String.valueOf(num);
        }
        
        Comparator<String> comparator = new Comparator<String>(){
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str2.compareTo(str1);
            }
        };
        
        Arrays.sort(stringNums, comparator);
        if(stringNums[0].charAt(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str : stringNums){
            sb.append(str);
        }
        return sb.toString();
    }
    
}