/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Make sure the returned strings are lexicographically sorted.

*/


//Solution

public class Solution {
	public ArrayList<String> letterCombinations(String a) {
	    
	    if(a==null||a.length() == 0){
	        return null;
	    }
	    HashMap<Integer, String> digitMap = new HashMap<Integer, String>();
        digitMap.put(2, "abc");digitMap.put(3, "def");digitMap.put(4, "ghi");digitMap.put(5, "jkl");
        digitMap.put(6, "mno");digitMap.put(7, "pqrs");digitMap.put(8, "tuv");digitMap.put(9, "wxyz");
        digitMap.put(0, "0");digitMap.put(1, "1");
        
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> temp = new ArrayList<Character>();
        getString(a,temp,result,digitMap);
        return result;
	    
	}
	public void getString(String a, ArrayList<Character> temp,ArrayList<String> result, HashMap<Integer, String> digitMap){
	    
	    if(a.length()==0){
	        char[] ar = new char[temp.size()];
	        for(int i=0;i<temp.size();i++){
	            ar[i] = temp.get(i);
	        }
	        result.add(String.valueOf(ar));
	        return;
	    }
	    Integer num = Integer.parseInt(a.substring(0,1));
	    String correspondingLetters = digitMap.get(num);
	    for(int i=0;i<correspondingLetters.length();i++){
	        temp.add(correspondingLetters.charAt(i));
	        getString(a.substring(1),temp,result,digitMap);
	        temp.remove(temp.size()-1);
	    }
	}
}
