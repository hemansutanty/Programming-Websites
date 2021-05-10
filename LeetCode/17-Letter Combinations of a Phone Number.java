import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0) return result;
        Map<String, String> phone = new HashMap<>();
        phone.put("2","abc");phone.put("3","def");
        phone.put("4","ghi");phone.put("5","jkl");
        phone.put("6","mno");phone.put("7","pqrs");
        phone.put("8","tuv");phone.put("9","wxyz");
        
        util(digits,"",phone, result);
        return result;
    }
    public void util(String digits, String prefix, Map<String, String> phone, List<String> result){
        if(digits==null || digits.length()==0){
            result.add(prefix);
            return;
        }
        String letters = phone.get(digits.charAt(0)+"");
        for(int i=0;i<letters.length();i++){
            util(digits.substring(1), prefix+letters.charAt(i), phone, result);
        }
    }
}